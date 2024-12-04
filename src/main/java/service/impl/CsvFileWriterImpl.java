package service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;
import service.FileWriter;

public class CsvFileWriterImpl implements FileWriter {
    private static final String TITLES = "fruit,quantity";
    private static final String PATH = "src/main/resources";

    @Override
    public void writeToFile(List<String> report, String filename) {
        File file = new File(PATH + File.separator + filename);
        String lines = convertToStringFormat(report);
        try (BufferedWriter bufferedWriter
                     = new BufferedWriter(new java.io.FileWriter(file, true))) {
            bufferedWriter.write(lines);
        } catch (IOException e) {
            throw new RuntimeException("Can't write in CSV file", e);
        }
    }

    private String convertToStringFormat(List<String> listReport) {
        listReport.add(0, TITLES);
        StringBuilder stringBuilder = new StringBuilder();
        for (String line : listReport) {
            stringBuilder.append(line).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
