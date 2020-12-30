package core.basesyntax.workwithfiles.impl;

import core.basesyntax.workwithfiles.DataReader;
import core.basesyntax.workwithfiles.DataValidator;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader implements DataReader {
    private final String path;
    private final DataValidator validator;

    public FileReader(String path) {
        this.path = path;
        validator = new DataValidatorImpl();
    }

    @Override
    public List<String> readData() {
        List<String> list = new ArrayList<>();
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(path))) {
            bufferedReader.readLine();
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
