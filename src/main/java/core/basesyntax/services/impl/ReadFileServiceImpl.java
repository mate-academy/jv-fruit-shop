package core.basesyntax.services.impl;

import core.basesyntax.exception.ValidationDataException;
import core.basesyntax.services.ReadFileService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileServiceImpl implements ReadFileService {
    @Override
    public String[] read(String fileName) {
        if (fileName == null) {
            throw new ValidationDataException("Path file cant be null!");
        }
        if (fileName.isEmpty()) {
            throw new ValidationDataException("Path file cant be empty!");
        }

        List<String> strLines = new ArrayList<>();
        try (FileReader reader = new FileReader(fileName);
                 BufferedReader bufferedReader = new BufferedReader(reader)) {
            String nextLine;
            while ((nextLine = bufferedReader.readLine()) != null) {
                strLines.add(nextLine);
            }
            if (strLines.isEmpty()) {
                throw new ValidationDataException("File is empty!");
            }
        } catch (IOException e) {
            throw new ValidationDataException("Path isnt correct. File or folder doesnt exist!");
        }
        return strLines.toArray(new String[0]);
    }
}
