package core.basesyntax.service.implementation;

import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> readFromFile(String filePath) {
        List<String> importedData;
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(filePath))) {
            importedData = new ArrayList<>();
            String line = bufferedReader.readLine();
            while (line != null) {
                importedData.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read file" + filePath, e);
        }
        return importedData;
    }
}
