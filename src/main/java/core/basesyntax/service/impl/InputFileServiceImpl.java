package core.basesyntax.service.impl;

import core.basesyntax.service.InputFileService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputFileServiceImpl implements InputFileService {
    @Override
    public List<List<String>> readFile(String filePath) {
        if (!filePath.endsWith(".csv")) {
            throw new RuntimeException("Not csv file format");
        }

        List<List<String>> fileStringsList = new ArrayList<>();
        String line = "";
        String cvsSeparator = ",";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                if (!line.matches(".+,.+,.+,.+")) {
                    throw new RuntimeException("File data in file");
                }
                String[] splittedLine = line.split(cvsSeparator);
                fileStringsList.add(new ArrayList<>(Arrays.asList(splittedLine)));
            }
        } catch (IOException e) {
            throw new RuntimeException("Problem with file reading");
        }

        return fileStringsList;
    }
}
