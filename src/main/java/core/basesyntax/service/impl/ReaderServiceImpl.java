package core.basesyntax.service.impl;

import core.basesyntax.service.interfaces.ReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReaderServiceImpl implements ReaderService {
    private static final String SOURCE_FILE_PATH = "dataTxt/input.txt";

    @Override
    public String readFromFile() {
        File file = new File(SOURCE_FILE_PATH);
        StringBuilder inputData = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                inputData.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Oops! File not found!");
        }
        return inputData.toString();
    }
}
