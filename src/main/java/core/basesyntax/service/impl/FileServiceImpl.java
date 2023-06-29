package core.basesyntax.service.impl;

import core.basesyntax.service.FileService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileServiceImpl implements FileService {
    @Override
    public List<String> readFromFile(String fromFile) {
        List<String> stringList;
        try {
            stringList = Files.readAllLines(Path.of(fromFile));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fromFile, e);
        }
        return stringList;
    }

    @Override
    public void writeToFile(String toFile, String content) {
        File file = new File(toFile);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + toFile, e);
        }

    }
}
