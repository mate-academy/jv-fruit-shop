package core.basesyntax.service.impl;

import core.basesyntax.exceptions.ReadDataFromFileException;
import core.basesyntax.service.FileReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReaderService implements FileReaderService {
    private static final int END_OF_THE_FILE = -1;

    @Override
    public String readDataFromFile(String fileName) {
        File fileFrom = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileFrom))) {
            int value = reader.read();
            if (value == END_OF_THE_FILE) {
                return "";
            }
            while (value != END_OF_THE_FILE) {
                builder.append((char)value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new ReadDataFromFileException("Can't read db from file " + fileName, e);
        }
        return builder.toString();
    }
}
