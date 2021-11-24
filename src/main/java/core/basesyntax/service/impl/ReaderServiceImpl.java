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
    public List<String> read(String pathToFile) {
        File file = new File(pathToFile);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            List<String> result = new ArrayList<>();
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                result.add(str);
            }
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file" + e);
        }
    }
}
