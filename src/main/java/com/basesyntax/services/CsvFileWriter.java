package com.basesyntax.services;

import java.util.List;

public interface CsvFileWriter {
    void createReportFile(String fileName, List<String> dataList);
}
