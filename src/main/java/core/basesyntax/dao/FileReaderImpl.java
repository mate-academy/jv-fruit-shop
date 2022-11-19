package core.basesyntax.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String path) {
        List<String> operations = new ArrayList<>();
        String tmp;
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(path))) {
            while ((tmp = bufferedReader.readLine()) != null) {
                operations.add(tmp);
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found " + e);
        }
        return operations;
    }
}
