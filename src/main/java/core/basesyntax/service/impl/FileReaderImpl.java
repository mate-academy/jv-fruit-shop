package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private List<String> dataFromFileReader;

    public List<String> getDataFromFileReader() {
        return this.dataFromFileReader;
    }

    @Override
    public List<String> getDataFromInputFile(String fileName) {
        File inputDataFile = new File("src/main/resources/" + fileName);
        try {
            inputDataFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file: " + inputDataFile, e);
        }
        try {
            return dataFromFileReader = Files.readAllLines(inputDataFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file: " + fileName, e);
        }
    }
}
