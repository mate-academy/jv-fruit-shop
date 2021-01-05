package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFilereaderImpl implements CsvFileReader {
    public static final int FIRST_LINE_FROM_FILE = 0;

    @Override
    public List<String> readFile(String fileName) {
        StringBuilder report = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value = reader.readLine();
            while (value != null) {
                report.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file - " + fileName, e);
        }
        String[] valuesReport = report.toString().split(System.lineSeparator());
        List<String> dataString = new ArrayList<>();
        for (String data: valuesReport) {
            dataString.add(data);
        }
        dataString.remove(FIRST_LINE_FROM_FILE);
        return dataString;
    }
}
