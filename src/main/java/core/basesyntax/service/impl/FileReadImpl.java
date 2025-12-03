package core.basesyntax.service.impl;

import core.basesyntax.service.FileRead;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReadImpl implements FileRead {
    @Override
    public List<String> readFileContents(String filePath) {
        List<String> listData = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                listData.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + filePath, e);
        }
        return listData;
    }
}
