package core.basesyntax.services.impl;

import core.basesyntax.services.FileReaderService;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> read(String fromFile) {
        List<String> dataFromFile = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fromFile))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                dataFromFile.add(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find such file " + fromFile, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fromFile, e);
        }
        return dataFromFile;
    }
}
