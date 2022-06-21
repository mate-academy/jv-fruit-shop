package service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    private static final String SPLITTER = "/";

    @Override
    public String[] readFile(String fromFileName) {
        StringBuilder dataFromFile = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fromFileName))) {
            String lineFromFile = bufferedReader.readLine();
            while (lineFromFile != null) {
                dataFromFile.append(lineFromFile).append(SPLITTER);
                lineFromFile = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fromFileName, e);
        }
        return dataFromFile.toString().split(SPLITTER);
    }
}
