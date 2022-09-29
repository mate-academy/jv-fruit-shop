package core.basesyntax.service;

import java.util.ArrayList;

public interface Service {
    String createFile(String fileName);

    void writeDataToFile(ArrayList<String> data, String fileFrom);

    void readDataFromFile(String fromFileName);

    int writeReportIntoFile(String file);
}
