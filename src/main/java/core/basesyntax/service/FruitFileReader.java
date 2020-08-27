package core.basesyntax.service;

import core.basesyntax.model.FruitBox;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FruitFileReader {

    public List<Operation> readOperation(String filename) {
        List<Operation> operations = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 4) {
                    continue;
                }
                String fruitName = parts[1];
                int amount = Integer.parseInt(parts[2]);
                LocalDate date = LocalDate.parse(parts[3]);
                FruitBox fruit = new FruitBox(fruitName, amount, date, false);
                Operation operation;
                switch (parts[0]) {
                    case "r":
                        operation = new Return(OperationType.RETURN, fruit);
                        break;
                    case "s":
                        operation = new Supply(OperationType.SUPPLY, fruit);
                        break;
                    case "b":
                        operation = new Buy(OperationType.BUY, fruit);
                        break;
                    default:
                        throw new RuntimeException("Unsuspected type of operation");
                }
                operations.add(operation);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File was not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        return operations;
    }
}
