package core.basesyntax.service.fileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFileImpl implements ReadFromFile {

    @Override
    public List<String> dataFromFile(String fileName) {
        List<String> dataFromFile = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            reader.readLine();
            String value = reader.readLine();
            while (value != null) {
                dataFromFile.add(value);
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not read from file " + fileName, e);
        }
        return dataFromFile;
    }
}
