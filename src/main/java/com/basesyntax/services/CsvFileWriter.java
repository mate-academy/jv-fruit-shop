package com.basesyntax.services;

import java.util.List;

public interface CsvFileWriter {
    void createFile(String pathName);

    void createReportFile(List<String> dataList);
}
