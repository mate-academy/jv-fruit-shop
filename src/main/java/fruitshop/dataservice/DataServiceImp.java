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
    public void writeDataToFile(String reportFile) {
        WorkWithReport supplierReport = new SupplierReport();
        try {
            Files.write(Path.of(reportFile), supplierReport.createReport());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file" + reportFile, e);
        }
    }
}
