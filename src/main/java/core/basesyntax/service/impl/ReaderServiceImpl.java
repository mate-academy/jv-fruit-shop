package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public String read(String fileName) {
        StringBuilder readDataBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                readDataBuilder.append(line).append(" ");
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from file: ", e);
        }
        return readDataBuilder.toString();
    }

}
