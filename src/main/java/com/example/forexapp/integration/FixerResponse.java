package com.example.forexapp.integration;

import lombok.Data;

import java.util.Map;

@Data
public class FixerResponse {
    private boolean success;
    private long timestamp;
    private String base;
    private String date;
    private Map<String, Double> rates;
}
