package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReaderService implements FileReaderService {
    @Override
    public String readFromFile(File file) {
        StringBuilder data = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String readLine = bufferedReader.readLine();
            while (readLine != null) {
                data.append(readLine).append(System.lineSeparator());
                readLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't open and read from the " + file.getName());
        }
        return data.toString();
    }
}
