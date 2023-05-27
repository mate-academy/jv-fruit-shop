package service;

import db.FruitsStorage;
import model.OutFileStructure;

////Interface for writing to the file.
public interface WriteToFile {
    void writeToCsvFile(String filePath, OutFileStructure structure, FruitsStorage storage);
}
