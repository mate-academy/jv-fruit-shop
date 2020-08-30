package app.service.impl;

import app.service.FileReadService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReadServiceImplementation implements FileReadService {
    private static final String SEPARATOR_TO_SPLIT = ",";

    @Override
    public List<List<String>> readFile(String filePath) {
        String line;
        List<List<String>> dataFromFile = new ArrayList<>();
        try (BufferedReader bufferedReaderFile = new BufferedReader(new FileReader(filePath))) {
            bufferedReaderFile.readLine();
            while ((line = bufferedReaderFile.readLine()) != null) {
                dataFromFile.add(Arrays.asList(line.split(SEPARATOR_TO_SPLIT)));
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to read file, reason: " + filePath, e);
        }
        return dataFromFile;
    }
}
