package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OutputResultFileService {
    private StringBuilder resultBuilder = new StringBuilder();

    public String sout() {
        try (BufferedReader resultReader
                     = new BufferedReader(new FileReader("storageContent.csv"))) {
            while (resultReader.readLine() != null) {
                resultBuilder.append(resultReader.readLine()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultBuilder.toString();
    }
}
