package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FruitCsvImpl implements FruitDao {

    @Override
    public List<FruitTransaction> getAll(File file) {
        List<String> fruits = new ArrayList<>();
        String line;
        try (BufferedReader br =
                     new BufferedReader(new FileReader(file))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                fruits.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file" + file.getPath(), e);
        }
        return fruits.stream().map(this::getFruitFromCsvRow).collect(Collectors.toList());
    }

    private FruitTransaction getFruitFromCsvRow(String line) {
        String[] fields = line.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        FruitTransaction.Operation operation = Arrays.stream(FruitTransaction.Operation.values())
                .filter(x -> x.getOperation().equals(fields[0]))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Can't find this operation"));
        fruitTransaction.setOperation(operation);
        fruitTransaction.setFruit(fields[1]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[2]));
        return fruitTransaction;
    }
}
