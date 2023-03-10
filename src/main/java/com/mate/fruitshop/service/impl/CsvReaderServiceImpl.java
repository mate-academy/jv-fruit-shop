package com.mate.fruitshop.service.impl;

import com.mate.fruitshop.service.CsvReaderService;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderServiceImpl implements CsvReaderService {
    @Override
    public List<String> read(String inputFileDir) {
        Path inputFile = Paths.get(inputFileDir);
        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(inputFile)) {
            while (bufferedReader.ready()) {
                lines.add(bufferedReader.readLine().stripLeading().stripTrailing());
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to read from file:" + inputFileDir, e);
        }
        return lines;
    }
}
