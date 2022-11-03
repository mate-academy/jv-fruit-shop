package com.basesyntax.services.impl;

import com.basesyntax.services.CsvFileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileReaderImpl implements CsvFileReader {
    private final File acceptedFile = new File("src/source/input.csv");

    @Override
    public List<String> getAcceptedFileAsList() {
        FileReader acceptedFileReader;
        List<String> fileAsList;
        try {
            acceptedFileReader = new FileReader(acceptedFile);
            fileAsList = new BufferedReader(acceptedFileReader)
                    .lines()
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return fileAsList;
    }
}
