package core.basesyntax.service.implementation;

import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String fileName) {
        List<String> listOfLines = new ArrayList<>();
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))) {
            bufferedReader.readLine();
            String line = bufferedReader.readLine();
            while (line != null) {
                listOfLines.add(line.trim());
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from " + fileName, e);
        }
        return listOfLines;
    }
}
