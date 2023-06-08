package core.basesyntax.db;

import java.util.List;

public interface DataBase {

    void writeDataToFile(List<String> listOfData);

    List<String> getDataFromFile();

    void clearFile();

}

