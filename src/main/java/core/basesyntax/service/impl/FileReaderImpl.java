package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileReaderImpl implements FileReader {
    private static final String RECORD_SEPARATOR = ";";

    @Override
    public String readFromFile(String fromFileName) {
        File file = new File(fromFileName);
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            String value;
            while ((value = reader.readLine()) != null) {
                stringBuilder.append(value).append(RECORD_SEPARATOR);
                value = reader.readLine();
            }
            String fromFileString = stringBuilder.toString();
            return stringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file" + fromFileName, e);
        }
    }
}
