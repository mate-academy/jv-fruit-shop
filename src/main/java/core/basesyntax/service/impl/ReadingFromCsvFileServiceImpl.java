package core.basesyntax.service.impl;

import core.basesyntax.service.ReadingFromCsvFileService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadingFromCsvFileServiceImpl implements ReadingFromCsvFileService {
    @Override
    public List<String> readFromFile(String fileName) {
        List<String> fileEntries = new ArrayList<>();
        File file = new File(fileName);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                fileEntries.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file " + fileName, e);
        }
        fileEntries.remove(0);
        return fileEntries;
    }
}

