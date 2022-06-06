package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> read(Path fileName) {
        List<String> data = new ArrayList<>();
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(fileName.toString()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(
                    String.format("Error read data from file '%s'", fileName), e);
        }
        return data;
    }
}
