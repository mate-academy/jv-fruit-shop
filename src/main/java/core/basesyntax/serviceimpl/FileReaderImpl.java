package core.basesyntax.serviceimpl;

import core.basesyntax.service.FileReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReaderService {

    @Override
    public List<String> getDataFromFile(File file) {
        List<String> dataFromFile = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();
            while (value != null) {
                dataFromFile.add(value);
                value = reader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file");
        }
        return dataFromFile;
    }
}
