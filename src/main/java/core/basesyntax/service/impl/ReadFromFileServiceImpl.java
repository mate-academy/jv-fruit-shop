package core.basesyntax.service.impl;

import core.basesyntax.service.ReadFromFileService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFileServiceImpl implements ReadFromFileService {
    @Override
    public String readFromFile(String pathToFile) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }

            return stringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + pathToFile, e);
        }
    }
}
