package core.basesyntax.db;

import core.basesyntax.service.CantReadFileWithThisNameException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FruitShopDaoImpl implements FruitShopDao {
    private int activitiesIndex = 0;
    private int fruitsIndex = 1;
    private int amountIndex = 2;

    @Override
    public List<String> getFromFile(String fromFileName) {
        try {
            return Files.readAllLines(Path.of(fromFileName));
        } catch (IOException e) {
            throw new CantReadFileWithThisNameException("We dont have file with this name");
        }
    }

    @Override
    public List<String> getFruits(List<String> fromFile) {
        return fromFile.stream()
                .map(l -> l.split(","))
                .map(a -> a[fruitsIndex])
                .distinct()
                .toList();
    }

    @Override
    public List<String> calculate(List<String> fruitList, String activities) {
        List<String> fruitsQuantity = new ArrayList<>();
        for (int i = 0; i < fruitList.size(); i++) {
            String actualFruit = fruitList.get(i);
            int balances = fruitList.stream()
                    .map(l -> l.split(","))
                    .filter(a -> a[activitiesIndex].equals(activities))
                    .filter(a -> a[fruitsIndex].equals(actualFruit))
                    .map(q -> q[amountIndex])
                    .mapToInt(Integer::valueOf)
                    .sum();
            fruitsQuantity.add(String.valueOf(balances));
        }
        return fruitsQuantity;
    }

}
