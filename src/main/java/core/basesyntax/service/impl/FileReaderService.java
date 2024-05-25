package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderService implements Reader {
    private static final int START_INDEX = 19;

    @Override
    public String[] read(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();

            while (value != null) {
                stringBuilder.append(value);
                value = bufferedReader.readLine();
            }

            return stringBuilder.toString()
                    .replace(" ", "")
                    .substring(START_INDEX)
                    .split("(?<=[0-9])(?=[a-zA-Z])");
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fileName, e);
        }
    }
}
