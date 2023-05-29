package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.WriteToFile;

/*
This class writes all data from the Fruits Storage to the file.
- receive String filePath, OutFileStructure, FruitsStorage
 */
public class WriteToCsvFileImpl implements WriteToFile {
    @Override
    public void writeToCsvFile(String filePath, String reportData) {
        try {
            Files.writeString(Path.of(filePath), reportData);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + filePath, e);
        }
    }
}
