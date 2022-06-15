package core.basesyntax.service.impl;

import core.basesyntax.service.FileHandler;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileHandlerImpl implements FileHandler {
    @Override
    public void writeFile(String fileName, String data) {
        final File toFile = new File(fileName);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFile))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file", e);
        }
    }

    @Override
    public List<String> readFile(String fileName) {
        List<String> readInfo;
        try {
            readInfo = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file" + fileName);
        }
        return readInfo;
    }

    @Override
    public void clearFile(String fileName) {
        try {
            Files.writeString(Path.of(fileName), "");
        } catch (IOException e) {
            throw new RuntimeException("Can't clear file" + fileName, e);
        }
    }
}
