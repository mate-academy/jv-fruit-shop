package core.basesyntax.service.impl;

import core.basesyntax.service.ReadFromFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFileImpl implements ReadFromFile {
    private static final String dayReportFilePath = "src/main/resources/transaction.csv";

    @Override
    public List<String> readFromFile() {
        File sourceFile = new File(dayReportFilePath);
        List<String> outputList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFile))) {
            String lineFromFile = bufferedReader.readLine();
            while (lineFromFile != null) {
                outputList.add(lineFromFile);
                lineFromFile = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Read error from file " + sourceFile + "!", e);
        }
        return outputList;
    }
}
