package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OutputResultFileService {
    private StringBuilder resultBuilder = new StringBuilder();
    private final String localPath = "storageContent.csv";

    public String sout(String filePath) {
        try (BufferedReader resultReader
                     = new BufferedReader(new FileReader(filePath))) {
            while (resultReader.readLine() != null) {
                resultBuilder.append(resultReader.readLine()).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Wrong path");
        }
        return resultBuilder.toString();
    }

    public String getLocalPath() {
        return localPath;
    }
}
