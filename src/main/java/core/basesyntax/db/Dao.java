package core.basesyntax.db;

import java.util.List;

public interface Dao {

    void writeDataToFile(List<String> listOfData);

    List<String> getDataFromFile();

    void clearFile();

    void addDataToFile(List<String> listOfData);

}

