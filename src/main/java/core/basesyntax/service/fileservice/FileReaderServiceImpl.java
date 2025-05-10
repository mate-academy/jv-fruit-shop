package core.basesyntax.service.fileservice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {

    @Override
    public List<String> readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            List<String> dataFromFile = new ArrayList<>();
            String valueFromFile = bufferedReader.readLine();
            while (valueFromFile != null) {
                dataFromFile.add(valueFromFile);
                valueFromFile = bufferedReader.readLine();
            }
            return dataFromFile;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fileName);
        }
    }
}
