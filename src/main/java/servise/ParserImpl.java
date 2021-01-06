package servise;

import dto.Activities;
import dto.Storage;
import exception.FruitShopException;
import java.util.ArrayList;
import java.util.List;
import model.Fruit;

public class ParserImpl implements Parser {

    @Override
    public List<Storage> parse(List<String> inputData) {
        if (!inputData.get(0).equals("type,fruit,quantity")) {
            throw new FruitShopException("Input data isn't valid");
        }
        List<Storage> storages = new ArrayList<>();
        for (int i = 1; i < inputData.size(); i++) {
            storages.add(parseLine(inputData.get(i)));
        }
        return storages;
    }

    private Storage parseLine(String line) {
        Storage currentStorage = new Storage();
        currentStorage.action = Activities.of(line.charAt(0));
        String [] stringsInputLine = line.split(",");
        currentStorage.fruit = new Fruit(stringsInputLine[1]);
        currentStorage.quantity = Integer.parseInt(stringsInputLine[2]);
        if (currentStorage.quantity < 0) {
            throw new FruitShopException("Quantity can't be negative");
        }
        return currentStorage;
    }
}
