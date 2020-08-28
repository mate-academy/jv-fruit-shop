package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FruitFileReader {
    List<FruitOperation> readOperation(String filename) {
        ParseOperation parseOperation = new ParseOperation();
        List<FruitOperation> operations = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 4) {
                    continue;
                }
                FruitOperation operation = parseOperation.getFruitOperation(parts);
                operations.add(operation);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not read the file", e);
        }
        return operations;
    }

}
