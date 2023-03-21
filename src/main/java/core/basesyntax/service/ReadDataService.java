package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadDataService {

    public List<String> readFromFile(String fromFileName) {
        List<String> data = new ArrayList<>();
        String value = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fromFileName));
            while ((value = br.readLine()) != null) {
                data.add(value);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fromFileName, e);
        }
        return data;
    }
}
