package core.basesyntax.service.file.impl;

import core.basesyntax.service.file.ReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class ReaderServiceImpl implements ReaderService {
    String filePath;

    public ReaderServiceImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String[] readFile() {
        File file = new File(filePath);
        String fileData = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            fileData = reader.lines()
                    .skip(1)
                    .collect(Collectors.joining(" "));
        } catch (IOException e) {
            throw new RuntimeException("Cannot find file", e);
        }
        return fileData.split(" ");
    }
}
