package core.basesyntax.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputDataReaderImpl implements InputDataReader {
    @Override
    public List<String> getDataFromFile(String filePathFrom) {
        List<String> dataFromFile = new ArrayList<>();
        String value;
        File file = new File(filePathFrom);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            value = bufferedReader.readLine();
            while (value != null) {
                dataFromFile.add(value);
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + filePathFrom);
        }
        return dataFromFile;
    }
}
