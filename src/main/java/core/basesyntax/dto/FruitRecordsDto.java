package core.basesyntax.dto;

import java.util.List;

public interface FruitRecordsDto {

    List<String> readDataFromFile(String fileName);

    void writeDataToFile(String filename, String data);
}
