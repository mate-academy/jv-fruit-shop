package fruitshop.dataservice;

import java.util.List;

public interface WorkWithFile {
    List<String> getDataFromFile(String file);

    void writeDataToFile(String reportFile);
}
