package com.example.forexapp.controller;

import com.example.forexapp.dto.ConversionHistoryRequest;
import com.example.forexapp.dto.CurrencyConversionRequest;
import com.example.forexapp.dto.CurrencyConversionResponse;
import com.example.forexapp.service.CurrencyConversionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CurrencyConversionController.class)
public class CurrencyConversionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CurrencyConversionService currencyConversionService;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConvertCurrency() throws Exception {
        CurrencyConversionRequest request = new CurrencyConversionRequest();
        request.setFromCurrency("USD");
        request.setToCurrency("EUR");
        request.setAmount(100);

        CurrencyConversionResponse response = new CurrencyConversionResponse();
        response.setConvertedAmount(85.0);
        response.setTransactionId("12345");

        when(currencyConversionService.convertCurrency(any(CurrencyConversionRequest.class))).thenReturn(response);

        mockMvc.perform(post("/api/v1/conversions")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.convertedAmount").value(85.0))
                .andExpect(jsonPath("$.transactionId").value("12345"));
    }

    @Test
    public void testGetConversionHistory() throws Exception {
        ConversionHistoryRequest request = new ConversionHistoryRequest();
        request.setTransactionId("12345");
        mockMvc.perform(get("/api/v1/conversions")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }
}
