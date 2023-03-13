package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            List<String> stringsList = new ArrayList<>();
            String reader = bufferedReader.readLine();
            while (reader != null) {
                stringsList.add(reader);
                reader = bufferedReader.readLine();
            }
            return stringsList;
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file" + fileName, e);
        }
    }
}
