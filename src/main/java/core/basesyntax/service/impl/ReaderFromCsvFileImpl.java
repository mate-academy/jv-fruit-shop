package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderFromCsvFile;

import java.io.*;

public class ReaderFromCsvFileImpl implements ReaderFromCsvFile {
    @Override
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + fileName, e);
        }
        return stringBuilder.toString()
                .split(System.lineSeparator());
    }
}
