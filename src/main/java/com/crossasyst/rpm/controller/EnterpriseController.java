package com.crossasyst.rpm.controller;

import com.crossasyst.rpm.model.Enterprise;
import com.crossasyst.rpm.response.EnterpriseResponse;
import com.crossasyst.rpm.service.EnterpriseService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Create enterprise", description = "Create enterprise")
@RequestMapping(path = "v1")
@RestController
public class EnterpriseController {
    private final EnterpriseService enterpriseService;

    @Autowired
    public EnterpriseController(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PostMapping(path = "/enterprises", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<EnterpriseResponse> createEnterprise(@RequestBody @Valid Enterprise enterprise) {
        EnterpriseResponse enterpriseResponse = enterpriseService.createEnterprise(enterprise);
        return new ResponseEntity<>(enterpriseResponse, HttpStatus.OK);
    }


    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @GetMapping(path = "/enterprises", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Enterprise>> getAllEnterprises() {
        List<Enterprise> enterprises = enterpriseService.findAllEnterprises();
        return new ResponseEntity<>(enterprises, HttpStatus.OK);

    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @GetMapping(path = "/enterprises/{enterpriseId}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Enterprise> findEnterprise(@PathVariable Long enterpriseId) {
        Enterprise enterprise = enterpriseService.findEnterprise(enterpriseId);
        return new ResponseEntity<>(enterprise, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PutMapping(path = "/enterprises/{enterpriseId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<String> updateEnterprise(@PathVariable Long enterpriseId, @RequestBody Enterprise enterprise) {
        enterpriseService.updateEnterprise(enterpriseId, enterprise);
        return new ResponseEntity("Enterprise updated successfully", HttpStatus.OK);
    }

}
