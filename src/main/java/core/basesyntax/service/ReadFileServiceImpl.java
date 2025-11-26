package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileServiceImpl implements ReadFileService {

    @Override
    public List<String> readFromFile(String filePath) {
        List<String> stringList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }

        return stringList;
    }
}
