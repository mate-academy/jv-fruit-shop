package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> readFromFile(String filePath) {
        List<String> dataArray = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))) {
            String data = reader.readLine();
            while (data != null) {
                dataArray.add(data);
                data = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file by path: " + filePath, e);
        }
        return dataArray;
    }
}
