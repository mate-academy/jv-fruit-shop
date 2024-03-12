package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderFileService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderFileServiceImpl implements ReaderFileService {
    @Override
    public String readFile(String pathFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(pathFile))) {
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append(System.lineSeparator());
            }
            return builder.toString().strip();
        } catch (IOException e) {
            throw new RuntimeException("Can`t find file by this " + pathFile + " " + e);
        }
    }
}
