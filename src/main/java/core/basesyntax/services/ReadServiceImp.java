package core.basesyntax.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadServiceImp implements ReadService {
    @Override
    public List<String> read(String filePath) {
        List<String> fileData = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileData.add(line);
            }
            return fileData;
        } catch (IOException e) {
            throw new RuntimeException("Can't read filePath: " + filePath, e);
        }
    }
}
