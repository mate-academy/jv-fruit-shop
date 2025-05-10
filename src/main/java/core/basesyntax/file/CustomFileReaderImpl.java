package core.basesyntax.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomFileReaderImpl implements CustomFileReader {

    @Override
    public List<String> read(String fileName) {
        List<String> fileData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileData.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file: " + fileName, e);
        }
        return fileData;
    }
}
