package core.basesyntax.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReaderDataFromFileImpl implements ReaderDataFromFile {

    @Override
    public List<String> readFromFile(String filePath) {
        File inputFile = new File(filePath);
        List<String> linesFromInputFile;
        try {
            linesFromInputFile = Files.readAllLines(inputFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }
        return linesFromInputFile;
    }
}
