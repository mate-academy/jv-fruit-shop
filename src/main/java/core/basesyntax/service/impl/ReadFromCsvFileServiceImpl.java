package core.basesyntax.service.impl;

import core.basesyntax.service.ReadFromCsvFileService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromCsvFileServiceImpl implements ReadFromCsvFileService {

    @Override
    public List<String> readFile(String fromFileName) {
        List<String> fruits = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fromFileName))) {
            reader.readLine(); //skipping 1st line
            String infoLine = reader.readLine();

            while (infoLine != null) {
                fruits.add(infoLine);
                infoLine = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot find file " + fromFileName);
        }

        return fruits;
    }
}
