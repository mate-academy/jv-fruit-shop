package core.basesyntax.service.impl;

import core.basesyntax.service.ReadDataService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadDataServiceImpl implements ReadDataService {
    @Override
    public List<String> readFromFile(String fromFileName) {
        List<String> data = new ArrayList<>();
        try (BufferedReader newBr = new BufferedReader(new FileReader(fromFileName))) {
            BufferedReader br = new BufferedReader(new FileReader(fromFileName));
            String value;
            while ((value = br.readLine()) != null) {
                data.add(value);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fromFileName, e);
        }
        return data;
    }
}
