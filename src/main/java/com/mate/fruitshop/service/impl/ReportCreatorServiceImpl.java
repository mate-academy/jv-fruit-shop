package com.mate.fruitshop.service.impl;

import com.mate.fruitshop.model.FruitEntry;
import com.mate.fruitshop.service.ReportCreatorService;
import java.util.List;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    public static final String REPORT_HEADER = "fruit,quantity";

    @Override
    public String createReport(List<FruitEntry> fruits) {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(REPORT_HEADER).append(System.lineSeparator());
        for (FruitEntry entry : fruits) {
            strBuilder.append(entry).append(System.lineSeparator());
        }
        return strBuilder.toString();
    }
}
