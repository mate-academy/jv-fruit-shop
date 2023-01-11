package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FruitCSVImpl implements FruitDao{
//    private static final String FILE_NAME = "FruitStore.csv";

//    @Override
//    public int get(String nameOfFruit) {
//        return Storage.fruits.get(nameOfFruit);
//    }

    @Override
    public List<FruitTransaction> getAll(File file) {
        List<String> fruits;
        try {
            fruits = Files.readAllLines(Path.of(file.getPath()));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file" + file.getPath());
        }
        return fruits.stream().map(this::getFruitFromCSVRow).collect(Collectors.toList());
    }
    private FruitTransaction getFruitFromCSVRow(String line) {
        String[] fields = line.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation.valueOf(fields[0]));
        fruitTransaction.setFruit(fields[1]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[2]));
        return fruitTransaction;
    }
}
