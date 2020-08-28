package app.service.impl;

import app.service.FileReadService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReadServiceImplementation implements FileReadService {
    public static final String SEPARATOR_TO_SPLIT = ",";

    @Override
    public List<List<String>> readFile(String filePath) {
        String line;
        List<List<String>> dataFromFile = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                dataFromFile.add(Arrays.asList(line.split(SEPARATOR_TO_SPLIT)));
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return dataFromFile;
    }
}
