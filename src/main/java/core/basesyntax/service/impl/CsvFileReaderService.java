package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;

import java.io.*;

public class CsvFileReaderService implements FileReaderService {
    private File readFile;

    public CsvFileReaderService(File readFile) {
        this.readFile = readFile;
    }

    @Override
    public String readFromFile() {
        StringBuilder data = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(readFile))) {
            String readLine = bufferedReader.readLine();
            while (readLine != null) {
                data.append(readLine).append(System.lineSeparator());
                readLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't open and read from the " + readFile.getName());
        }
        return data.toString();
    }
}
