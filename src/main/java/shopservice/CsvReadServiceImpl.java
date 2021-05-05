package shopservice;

import datavalidation.DataValidatorImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvReadServiceImpl implements ReadService {

    @Override
    public List<String> readFromFile(String filePath) {
        List<String> dataFromFile;
        int dataIndex = 0;
        try {
            dataFromFile = Files.readAllLines(Path.of(filePath));
            String data;
            while (dataIndex != dataFromFile.size()) {
                data = dataFromFile.get(dataIndex);
                new DataValidatorImpl().validateData(data);
                dataIndex++;
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + filePath);
        }
        return dataFromFile;
    }
}
