package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderFromFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReaderFromFileImpl implements ReaderFromFile {
    private static final String RECORD_SEPARATOR = ";";

    @Override
    public String readFromFile(String fromFileName) {
        File file = new File(fromFileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(RECORD_SEPARATOR);
                value = reader.readLine();
            }
            String fromFileString = stringBuilder.toString();
            return stringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException("can't read file" + fromFileName, e);
        }
    }
}
