package com.example.testammper.service;

import com.example.testammper.client.BelvoClient;
import com.example.testammper.exception.BelvoException;
import com.example.testammper.model.entity.BanksEntity;
import com.example.testammper.model.request.balance.BalanceBelvoRequest;
import com.example.testammper.model.request.balance.BalanceRequest;
import com.example.testammper.model.request.links.RegisterLinkRequest;
import com.example.testammper.model.response.BalanceResponse;
import com.example.testammper.model.response.InstitutionsResponse;
import com.example.testammper.model.response.belvo.balance.Balance;
import com.example.testammper.model.response.belvo.balance.BalanceBelvoResponse;
import com.example.testammper.model.response.belvo.balance.BalanceDetailResponse;
import com.example.testammper.model.response.belvo.institutions.BelvoInstitutionsResponse;
import com.example.testammper.model.response.belvo.institutions.InstitutionsDetailResponse;
import com.example.testammper.model.response.belvo.links.RegisterLinkResponse;
import com.example.testammper.repository.BanksRepository;
import com.example.testammper.utils.EncryptionMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.management.BadAttributeValueExpException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BelvoServiceImpl implements BelvoService {

    @Autowired
    private BelvoClient belvoClient;

    @Autowired
    private BanksRepository banksRepository;

    @Autowired
    EncryptionMethods encryptionMethods;

    @Value("${banks.user}")
    private String user;

    @Value("${banks.pass}")
    private String pass;

    @Override
    public List<InstitutionsResponse> getInstitutions() {
        boolean hasMoreData = true;
        int page = 1;
        List<InstitutionsResponse> institutionsResponseList = new ArrayList<>();
        while (hasMoreData) {
            BelvoInstitutionsResponse response = belvoClient.getInstitutions(page);
            institutionsResponseList.addAll(ServiceMapper.INSTANCE.toInstitutionsResponseList(response.getResults()));
            if (institutionsResponseList.size() >= response.getCount()) {
                hasMoreData = false;
            }
            page++;
        }
        return institutionsResponseList;
    }

    @Override
    public BalanceResponse getBalance(BalanceRequest request) {
        Optional<BanksEntity> optionalBank = banksRepository.findById(request.getId());
        BanksEntity bank;
        if (optionalBank.isPresent()) {
            bank = optionalBank.get();
        } else {
            bank = createBankEntity(request.getId());
        }

        BalanceBelvoRequest balanceBelvoRequest = new BalanceBelvoRequest();
        balanceBelvoRequest.setLink(bank.getLink());
        balanceBelvoRequest.setDateForm(request.getDateForm());
        balanceBelvoRequest.setDateTo(request.getDateTo());
        List<BalanceDetailResponse> balanceDetailResponses;
        try {
            balanceDetailResponses = belvoClient.getBalanceAccount(balanceBelvoRequest);
        }catch (Exception ex){
            throw new BelvoException(ex.getMessage());
        }

        double incomes = balanceDetailResponses.stream().filter(x->x.getType().equals("INFLOW")).mapToDouble(BalanceDetailResponse::getAmount).sum();
        double expenses = balanceDetailResponses.stream().filter(x->x.getType().equals("OUTFLOW")).mapToDouble(BalanceDetailResponse::getAmount).sum();
        double balance = incomes - expenses;
        return new BalanceResponse(incomes, expenses, balance);
    }

    private BanksEntity createBankEntity(int id){
        InstitutionsDetailResponse detailResponse = belvoClient.getInstitutionDetail(id);
        String regexUser = detailResponse.getFormFields().stream().filter(x->x.getName().equals("username")).findFirst().get().getValidation();
        String regexPass = detailResponse.getFormFields().stream().filter(x->x.getName().equals("password")).findFirst().get().getValidation();
        String user = encryptionMethods.genMatchString(regexUser);
        String pass = encryptionMethods.genMatchString(regexPass);
        RegisterLinkResponse newBankLink = belvoClient.registerLink(new RegisterLinkRequest(detailResponse.getName(), user, pass));

        return banksRepository.save(new BanksEntity(id,detailResponse.getName(), newBankLink.getId(), encryptionMethods.encrypt(user), encryptionMethods.encrypt(pass)));
    }
}
