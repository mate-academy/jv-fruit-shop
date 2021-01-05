package core.basesyntax.service.file.impl;

import core.basesyntax.service.file.DataReader;
import core.basesyntax.service.file.DataValidator;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader implements DataReader {
    private final DataValidator validator;

    public FileReader(DataValidator dataValidator) {
        validator = dataValidator;
    }

    @Override
    public List<String> readData(String path) {
        List<String> list = new ArrayList<>();
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(path))) {

            while ((line = bufferedReader.readLine()) != null) {
                list.add(line.trim());
            }
        } catch (IOException e) {
            throw new RuntimeException("File was not found");
        }
        validator.validate(list);
        return list;
    }
}
