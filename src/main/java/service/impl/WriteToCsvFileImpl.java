package service.impl;

import db.FruitsStorage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import model.OutFileStructure;
import service.WriteToFile;

/*
This class writes all data from the Fruits Storage to the file.
- receive String filePath, OutFileStructure, FruitsStorage
 */
public class WriteToCsvFileImpl implements WriteToFile {
    @Override
    public void writeToCsvFile(String filePath, OutFileStructure structure, FruitsStorage storage) {
        File file = new File(filePath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false))) {
            bufferedWriter.write(structure.getColumn1() + ","
                    + structure.getColumn2() + System.lineSeparator());
            for (var node : storage.getFruitsStorage().entrySet()) {
                bufferedWriter.write(node.getKey() + ","
                        + node.getValue() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + filePath, e);
        }
    }
}
