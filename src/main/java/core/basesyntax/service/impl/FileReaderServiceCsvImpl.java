package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceCsvImpl implements FileReaderService {
    private static final String CSV_SPLIT_BY = ",";

    @Override
    public List<String> read(String filePath) {
        String line = "";
        List<String> dataFromFile = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                dataFromFile.add(line.trim());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataFromFile;
    }
}
