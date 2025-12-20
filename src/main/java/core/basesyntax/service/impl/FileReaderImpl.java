package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderImpl implements Reader {
    @Override
    public List<String> read(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException(
                    "File name cannot be null or empty" + fileName);
        }

        File file = new File(fileName);
        if (!file.exists()) {
            throw new RuntimeException(
                    "File not found: " + fileName);
        }
        try (BufferedReader reader
                     = new BufferedReader(new FileReader(fileName))) {
            List<String> lines = reader.lines()
                    .collect(Collectors.toList());
            if (lines.isEmpty()) {
                throw new RuntimeException(
                        "File is empty: " + fileName);
            }
            return lines;
        } catch (IOException e) {
            throw new RuntimeException(
                    "Can't read info from file: " + fileName, e);
        }
    }
}
