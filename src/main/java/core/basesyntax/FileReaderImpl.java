package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReaderMet {
    @Override
    public List<String> readFile(String fileName) {
        List<String> fruits = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                fruits.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from file " + fileName);
        }
        return fruits;
    }
}
