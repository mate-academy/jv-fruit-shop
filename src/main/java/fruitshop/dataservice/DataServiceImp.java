package fruitshop.dataservice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DataServiceImp implements WorkWithFile {

    @Override
    public List<String> getDataFromFile(String file) {
        List<String> readData;
        try {
            readData = Files.readAllLines(Path.of(file));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file" + e);
        }
        return readData;
    }

    @Override
    public void writeDataToFile(String reportToFile, List<String> convertReport) {
        try {
            Files.write(Path.of(reportToFile), convertReport);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file" + reportToFile, e);
        }
    }
}
