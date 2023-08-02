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
        List<String> strLines = new ArrayList<>();
        try (FileReader reader = new FileReader(fileName);
                 BufferedReader bufferedReader = new BufferedReader(reader)) {
            String nextLine;
            while ((nextLine = bufferedReader.readLine()) != null) {
                strLines.add(nextLine);
            }
        } catch (IOException e) {
            throw new ValidationDataException("Cant read the file!");
        }
        return strLines.toArray(new String[0]);
    }
}
