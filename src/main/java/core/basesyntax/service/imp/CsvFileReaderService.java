package core.basesyntax.service.imp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderService {

    public List<String> readFile(String fileName) {
        List<String> listFromFile = new ArrayList<>();
        String line;
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            line = bufferedReader.readLine();
            if (line == null) {
                throw new RuntimeException("File " + fileName + " is empty");
            }
            while (line != null) {
                line = bufferedReader.readLine();
                if (line != null) {
                    listFromFile.add(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + file, e);
        }
        return listFromFile;
    }
}
