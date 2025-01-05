package core.basesyntax.services.impl;

import core.basesyntax.services.FileDataReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileDataReaderImpl implements FileDataReader {
    @Override
    public List<String> readData(Path path) {
        List<String> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toFile()))) {
            bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read data from file " + path.toString(), e);
        }
        return list;
    }
}
