package core.basesyntax.fruitshop.file.reader;

import core.basesyntax.fruitshop.ValidatorImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskReaderImpl implements TaskReader {

    @Override
    public List<String[]> readFile(String fromFile) {
        String[] inputData;
        ValidatorImpl validator = new ValidatorImpl();
        List<String[]> tempStorage = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fromFile))) {
            reader.readLine();
            String line = reader.readLine();
            while (line != null) {
                inputData = line.trim().split(",");
                validator.validate(line);
                tempStorage.add(inputData);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find the file", e);
        }
        return tempStorage;
    }
}
