package service.impl;

import dao.FruitDao;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import model.FruitType;
import service.SaveToFileSystem;

public class SaveToFileSystemImpl implements SaveToFileSystem {
    private final FruitDao fruitDao;

    public SaveToFileSystemImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void writeToFileFromDataBase(String fileName) {
        try (FileWriter writer = new FileWriter(fileName);) {
            for (Map.Entry<FruitType, Integer> entry : fruitDao.getEntries()) {
                writer.write(entry.getKey() + "," + entry.getValue() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file");
        }
    }
}
