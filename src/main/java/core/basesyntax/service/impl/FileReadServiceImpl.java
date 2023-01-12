package core.basesyntax.service.impl;

import core.basesyntax.service.FileReadService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadServiceImpl implements FileReadService {
    @Override
    public String readFromFile(String path) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String data = reader.readLine();
            while (data != null) {
                builder.append(data).append(System.lineSeparator());
                data = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file " + e);
        }
        return builder.toString();
    }
}
