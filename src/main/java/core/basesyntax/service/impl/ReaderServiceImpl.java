package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {

    @Override
    public List<String> read(String filePath) {
        List<String> records = new ArrayList<>();
        File file = new File(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine();
            String record;
            while ((record = reader.readLine()) != null) {
                records.add(record);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read " + filePath, e);
        }
        return records;
    }
}
