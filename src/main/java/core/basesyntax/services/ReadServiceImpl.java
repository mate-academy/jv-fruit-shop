package core.basesyntax.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadServiceImpl implements ReadService {
    @Override
    public List<String> readFile(String fromFile) {
        List<String> dataList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fromFile))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                dataList.add(value);
                value = bufferedReader.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return dataList;
    }
}
