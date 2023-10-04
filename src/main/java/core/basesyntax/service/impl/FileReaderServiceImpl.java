package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public String[] readFromFile(String filepath) {
        List<String> fileLines = new ArrayList<>();
        String fileLine;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath))) {
            bufferedReader.readLine();
            fileLine = bufferedReader.readLine();
            while (fileLine != null) {
                fileLines.add(fileLine);
                fileLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file: " + filepath, e);
        }
        return fileLines.toArray(new String[0]);
    }
}
