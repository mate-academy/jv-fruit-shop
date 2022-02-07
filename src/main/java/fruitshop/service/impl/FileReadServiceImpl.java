package fruitshop.service.impl;

import fruitshop.service.file.FileReadService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadServiceImpl implements FileReadService {
    private final WriteDataToStorageImpl writeDataToStorage = new WriteDataToStorageImpl();

    @Override
    public void readDataFromFile(String filepath) {
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath))) {
            while ((line = bufferedReader.readLine()) != null) {
                writeDataToStorage.writeDate(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from the file " + e);
        }
    }
}
