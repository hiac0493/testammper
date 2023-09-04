package com.example.testammper.client;

import com.example.testammper.model.request.balance.BalanceBelvoRequest;
import com.example.testammper.model.request.links.RegisterLinkRequest;
import com.example.testammper.model.response.belvo.balance.BalanceDetailResponse;
import com.example.testammper.model.response.belvo.institutions.BelvoInstitutionsResponse;
import com.example.testammper.model.response.belvo.institutions.InstitutionsDetailResponse;
import com.example.testammper.model.response.belvo.links.RegisterLinkResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "belvoClient", url = "${belvo.client.url}", configuration = BelvoClientConfig.class)
public interface BelvoClient {

    @GetMapping(value = "/api/institutions", produces = MediaType.APPLICATION_JSON_VALUE)
    BelvoInstitutionsResponse getInstitutions(@RequestParam("page") int page);

    @GetMapping(value = "/api/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
    List<BalanceDetailResponse> getBalanceAccount(@RequestBody BalanceBelvoRequest request);

    @PostMapping(value = "/api/links/", produces = MediaType.APPLICATION_JSON_VALUE)
    RegisterLinkResponse registerLink(@RequestBody RegisterLinkRequest request);

    @GetMapping(value = "/api/institutions/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    InstitutionsDetailResponse getInstitutionDetail(@PathVariable int id);
}
