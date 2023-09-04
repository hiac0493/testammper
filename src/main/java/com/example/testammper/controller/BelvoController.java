package com.example.testammper.controller;

import com.example.testammper.model.request.balance.BalanceRequest;
import com.example.testammper.model.response.BalanceResponse;
import com.example.testammper.model.response.InstitutionsResponse;
import com.example.testammper.service.BelvoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class BelvoController {

    @Autowired
    BelvoService belvoService;

    @Tag(name = "Institutions")
    @Operation(summary = "Get list of institutions", description = "Obtain list of all institutions in Belvo")
    @Schema(name = "Institutions", implementation = InstitutionsResponse.class)
    @ApiResponse(responseCode = "200", description = "On Success")
    @GetMapping(value = "/institutions")
    public ResponseEntity<List<InstitutionsResponse>> getInstitutions(){
        List<InstitutionsResponse> response = belvoService.getInstitutions();
        if(response.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Tag(name = "Balance")
    @Operation(summary = "Get Balance of Bank", description = "Total income minus expenses. (Format date YYYY-MM-DD)")
    @ApiResponse(responseCode = "200", description = "On Success")
    @PostMapping(value = "/balance")
    public ResponseEntity<BalanceResponse> getBankBalance(@RequestBody BalanceRequest balanceRequest){
        return new ResponseEntity<>(belvoService.getBalance(balanceRequest), HttpStatus.OK);
    }
}
