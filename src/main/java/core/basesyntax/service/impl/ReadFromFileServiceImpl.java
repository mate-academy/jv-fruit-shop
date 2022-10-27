package core.basesyntax.service.impl;

import core.basesyntax.service.ReadFromFileService;
import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFromFileServiceImpl implements ReadFromFileService {
    private static final String END_LINE = System.lineSeparator();

    @Override
    public String readFromFile(String path) {
        String line = "";
        StringBuilder dataFromFile = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while ((line = bufferedReader.readLine()) != null) {
                dataFromFile.append(line).append(END_LINE);
            }
        } catch (Exception e) {
            throw new RuntimeException("Can`t read data from file", e);
        }
        return dataFromFile.toString();
    }
}
