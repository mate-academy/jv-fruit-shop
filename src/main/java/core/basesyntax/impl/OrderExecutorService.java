package core.basesyntax.impl;

import core.basesyntax.Consumer;
import core.basesyntax.OrderExecutor;
import core.basesyntax.Returner;
import core.basesyntax.Storage;
import core.basesyntax.Supplier;
import core.basesyntax.model.Fruit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class OrderExecutorService implements OrderExecutor {
    private static final String SPLITTER = ",";

    @Override
    public String execute(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.replaceAll("\"", "").split(SPLITTER);
                Fruit fruit
                        = new Fruit(data[1], LocalDate.parse(data[3]), Integer.parseInt(data[2]));
                switch (data[0]) {
                    case "s":
                        Supplier<Fruit> receiver = new FruitReceive();
                        receiver.supplyFruit(fruit);
                        break;
                    case "b":
                        Consumer<Fruit> seller = new FruitSell();
                        seller.sellFruit(fruit);
                        break;
                    case "r":
                        Returner<Fruit> returner = new FruitReturn();
                        returner.returnFruit(fruit);
                        break;
                    default:
                        throw new NullPointerException("Empty file");
                }
            }
            System.out.println(Storage.fruitStorage.peek().getName() + ","
                    + Storage.fruitStorage.peek().amount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder result = new StringBuilder();
        for (Fruit fruit : Storage.fruitStorage) {
            result.append(fruit.getName())
                    .append(",")
                    .append(fruit.amount);
        }
        return result.toString();
    }
}
