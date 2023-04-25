package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadScvServiceImpl implements ReadScvService{
    @Override
    public List<Fruit> readFromFileDataCsv() {
        List<Fruit> fruits = new ArrayList<>();
        String filePath = "data.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] value = line.split((","));
                Fruit fruit = new Fruit(value[0], Integer.parseInt(value[1]));
                fruits.add(fruit);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fruits;
    }

    @Override
    public List<FruitTransaction> readFromFileInputCsv() {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        String filePath = "input.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                FruitTransaction fruitTransaction = new FruitTransaction();
                String[] value = line.split((","));

                fruitTransaction.setOperation(FruitTransaction.Operation.fromCode(value[0]));
                fruitTransaction.setFruit(value[1]);
                fruitTransaction.setQuantity(Integer.parseInt(value[2]));
                fruitTransactions.add(fruitTransaction);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fruitTransactions;
    }
}
