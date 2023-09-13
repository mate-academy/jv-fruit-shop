package service.impl;

import db.Storage;
import service.Writer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WriterImpl implements Writer {
    private static final String HEADER = "fruit,quantity";
    @Override
    public void writeToFile(String filepath) {
        List<String[]> storageLines = new ArrayList<>();
        storageLines.add(HEADER.split(","));
        for (Map.Entry<String, Integer> entry : Storage.getFruits().entrySet()) {
            storageLines.add(new String[]{ entry.getKey(), String.valueOf(entry.getValue()) });
        }

        File outputFile = new File(filepath);
        try (PrintWriter printWriter = new PrintWriter(outputFile)) {
            storageLines.stream()
                    .map(this::convertToCSV)
                    .forEach(printWriter::println);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private String convertToCSV(String[] data) {
        return Stream.of(data)
                .collect(Collectors.joining(","));
    }
}
