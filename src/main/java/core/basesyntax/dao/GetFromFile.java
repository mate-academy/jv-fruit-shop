package core.basesyntax.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetFromFile implements IGetInfoDao {
    @Override
    public List<String> getData(String path) {
        List<String> operations = new ArrayList<>();
        String tmp;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while ((tmp = bufferedReader.readLine()) != null) {
                operations.add(tmp);
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found " + e);
        }
        return operations;
    }
}
