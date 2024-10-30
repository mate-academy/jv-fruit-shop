package core.basesyntax.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FruitFileDaoReaderImpl implements FruitFileDaoReader {
    @Override
    public List<String> read(String fileNameFrom) {
        List<String> fileLines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileNameFrom))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileLines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + fileNameFrom, e);
        }
        return fileLines;
    }
}
