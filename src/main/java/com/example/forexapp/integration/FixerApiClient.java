package com.example.forexapp.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "fixerApiClient", url = "${fixer.api.url}")
public interface FixerApiClient {

    @GetMapping
    FixerResponse getExchangeRate(@RequestParam("symbols") String symbols);
}
