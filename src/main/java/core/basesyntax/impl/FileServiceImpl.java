package core.basesyntax.impl;

import core.basesyntax.service.FileService;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl implements FileService {
    @Override
    public List<String> readDataFromFile(String path) {
        List<String> fruitData = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fruitData.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + path, e);
        }
        return fruitData;
    }

    @Override
    public void write(String path, String content) {
        File file = new File(path);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + path);
        }
    }
}
