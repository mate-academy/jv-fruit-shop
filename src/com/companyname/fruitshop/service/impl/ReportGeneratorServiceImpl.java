package com.companyname.fruitshop.service.impl;

import com.companyname.fruitshop.service.interfaces.ReportGeneratorService;

import java.io.File;
import java.util.Map;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private final Map<String, Integer> data;

    public ReportGeneratorServiceImpl(Map<String, Integer> data) {
        this.data = data;
    }

    @Override
    public File generateReport(String fileName) {
        File report = new File(fileName);
        return report;
    }
}
