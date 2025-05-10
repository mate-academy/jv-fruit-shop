package core.basesyntax.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MyFileReaderImpl implements MyFileReader {

    @Override
    public List<String> read(String fileName) {
        List<String> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            records = Files.readAllLines(Path.of(fileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find the file: " + fileName, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file: " + fileName, e);
        }
        return records;
    }
}
