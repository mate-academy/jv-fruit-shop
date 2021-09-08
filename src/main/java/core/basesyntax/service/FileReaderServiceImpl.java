package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    private static final String CANT_READ_FROM_FILE_EXCEPTION = "Can't read from file.";

    @Override
    public List<String> readRowsFromFile(String fileName) {
        List<String> rows = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                rows.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(CANT_READ_FROM_FILE_EXCEPTION);
        }
        return rows;
    }
}
