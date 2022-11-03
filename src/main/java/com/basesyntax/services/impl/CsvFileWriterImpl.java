package com.basesyntax.services.impl;

import com.basesyntax.services.CsvFileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvFileWriterImpl implements CsvFileWriter {
    private static final String NEW_LINE = System.lineSeparator();
    private File acceptedPathName;
    @Override
    public void createFile(String pathName) {
        acceptedPathName = new File(pathName);
    }

    @Override
    public void createReportFile(List<String> dataList) {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity" + NEW_LINE);
        dataList.stream().sorted().forEach(m -> stringBuilder.append(m).append(NEW_LINE));
        FileWriter writerForReport;
        try {
            writerForReport = new FileWriter(acceptedPathName);
            BufferedWriter bufferedWriter = new BufferedWriter(writerForReport);
            bufferedWriter.write(stringBuilder.toString().trim());
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
