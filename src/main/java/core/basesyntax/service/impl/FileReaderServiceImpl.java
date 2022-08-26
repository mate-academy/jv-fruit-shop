package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String pathName) {
        List<String> readFromFile = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathName))) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                readFromFile.add(line);
            }
        } catch (FileNotFoundException exception) {
            throw new RuntimeException("Can't find file name:" +pathName, exception);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file named: " + pathName, e);
        }
        return readFromFile;
    }
}
