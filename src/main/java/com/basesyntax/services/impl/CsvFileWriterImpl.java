package com.basesyntax.services.impl;

import com.basesyntax.services.CsvFileWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvFileWriterImpl implements CsvFileWriter {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public void createReportFile(String fileName, List<String> dataList) {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity" + LINE_SEPARATOR);
        dataList.stream().sorted().forEach(m -> stringBuilder.append(m).append(LINE_SEPARATOR));
        FileWriter writerForReport;
        try {
            writerForReport = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(writerForReport);
            bufferedWriter.write(stringBuilder.toString().trim());
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
