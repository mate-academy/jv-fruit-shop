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
            String data = dataFromFile.get(dataIndex);
            while (dataIndex + 1 != dataFromFile.size()) {
                new DataValidatorImpl().validateData(data);
                dataIndex++;
                data = dataFromFile.get(dataIndex);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + filePath);
        }
        return dataFromFile;
    }
}
