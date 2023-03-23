package core.basesyntax.service.filereader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> dataFromFile(String fileName) {
        List<String> dataFromFile = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName))) {
            reader.readLine();
            String value = reader.readLine();
            while (value != null) {
                dataFromFile.add(value);
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not read from file " + fileName, e);
        }
        return dataFromFile;
    }
}
