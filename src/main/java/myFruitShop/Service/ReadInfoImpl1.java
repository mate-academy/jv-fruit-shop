package myFruitShop.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReadInfoImpl1 implements ReadInfo {
    public List<String> readFromFile(String inputFilePath) {
        File inputFile = new File(inputFilePath);
        try {
            List<String> inputFileInfo = Files.readAllLines(inputFile.toPath());
            return inputFileInfo;
        } catch (IOException e) {
            throw new RuntimeException("Can't read File", e);
        }
    }
}
