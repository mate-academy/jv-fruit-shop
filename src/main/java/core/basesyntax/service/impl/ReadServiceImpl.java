package core.basesyntax.service.impl;

import core.basesyntax.service.ReadService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadServiceImpl implements ReadService {
    @Override
    public List<String> readFromFile(String filePath) {
        List<String> list = new ArrayList<>();
        File file = new File(filePath);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                list.add(value);
                value = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file ", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return list;
    }
}
