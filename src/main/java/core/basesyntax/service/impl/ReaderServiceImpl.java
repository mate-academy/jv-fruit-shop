package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    public List<String> readFromFile(String filePath) {
        List<String> list = new ArrayList<>();
        File file = new File(filePath);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String string = bufferedReader.readLine();
            while (string != null) {
                list.add(string);
                string = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file. " + e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file. " + e);
        }
        return list;
    }
}
