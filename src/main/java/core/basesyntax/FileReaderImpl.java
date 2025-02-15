package core.basesyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReaderMet {
    @Override
    public List<String> readFile(String fileName) {
        List<String> fruits = new ArrayList<>();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new RuntimeException("File not found: " + fileName);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                fruits.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from file " + fileName, e);
        }
        return fruits;
    }
}
