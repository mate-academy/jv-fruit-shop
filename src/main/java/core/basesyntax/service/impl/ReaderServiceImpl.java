package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromCsvFile(String path) {
        File file = new File(path);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String data = bufferedReader.readLine(); // read header
            data = bufferedReader.readLine();
            List<String> resultList = new ArrayList<>();
            while (data != null) {
                resultList.add(data);
                data = bufferedReader.readLine();
            }
            return resultList;
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file " + path, e);
        }
    }
}
