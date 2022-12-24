package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReaderServiceImpl implements ReaderService {
    public String readFromFile(String fromFileName) {
        File nameFileFrom = new File(fromFileName);
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nameFileFrom));
            String line = reader.readLine();
            while (line != null) {
                builder.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from " + fromFileName, e);
        }
        return builder.toString();
    }
}
