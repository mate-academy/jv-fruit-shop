package core.basesyntax.interfaces;

import core.basesyntax.FruitRecord;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFileImpl implements ReadFromFile {

    @Override
    public List<FruitRecord> read(String pathToFile) {
        List<FruitRecord> records = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(pathToFile));

            for (int i = 1; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(",");
                String operation = parts[0];
                String fruit = parts[1];
                int quantity = Integer.parseInt(parts[2]);

                records.add(new FruitRecord(operation, fruit, quantity));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from this file!");
        }
        return records;
    }
}
