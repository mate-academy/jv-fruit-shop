package core.basesyntax.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {

    @Override
    public List<String> getDataFromFile(String filePath) {
        List<String> listOfInfo = new ArrayList<>();
        File file = new File(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine();
            String value = reader.readLine();
            while (value != null) {
                listOfInfo.add(value);
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }
        return listOfInfo;
    }
}
