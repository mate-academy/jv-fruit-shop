package core.basesyntax.service.impl;

import core.basesyntax.exception.FileNotFoundException;
import core.basesyntax.service.FileReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String fileNameToRead) {
        List<String> listFromFile = new ArrayList<>();
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileNameToRead))) {
            bufferedReader.readLine();
            while (bufferedReader.ready()) {
                line = bufferedReader.readLine();
                if (line != null) {
                    listFromFile.add(line);
                }
            }
        } catch (IOException e) {
            throw new FileNotFoundException("Can't find file" + fileNameToRead);
        }
        return listFromFile;
    }
}
