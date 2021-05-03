package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String filename) {
        List<String> fileLines = new ArrayList<>();
        File file = new File(filename);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()) {
                fileLines.add(bufferedReader.readLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File " + filename + " doesn't exist");
        } catch (IOException e) {
            throw new RuntimeException("No data in file");
        }
        return fileLines;
    }
}
