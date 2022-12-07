package dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvTransactionDaoImpl implements CsvTransactionDao {

    @Override
    public void createDaoFolder(String folderName) {
        File folder = new File(folderName);
        folder.mkdir();
    }

    @Override
    public void createFile(String fileName, String folderName) {
        String filePath = getPath(fileName, folderName);
        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create new file", e);
        }
    }

    @Override
    public List<String> readFromFile(String fileName, String folderName) {
        String filePath = getPath(fileName, folderName);
        List<String> fruitOperations;
        try {
            fruitOperations = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + fileName);
        }
        return fruitOperations;
    }

    @Override
    public void writeToFile(String data, String fileName, String folderName) {
        String filePath = getPath(fileName, folderName);
        try {
            Files.writeString(Path.of(filePath), data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to " + fileName, e);
        }
    }

    private String getPath(String fileName, String folderName) {
        return folderName + File.separator + fileName;
    }
}
