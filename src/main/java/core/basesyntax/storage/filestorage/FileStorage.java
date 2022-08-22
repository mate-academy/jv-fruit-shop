package core.basesyntax.storage.filestorage;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitMovement;
import core.basesyntax.storage.DataBase;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileStorage extends DataBase {
    private static final String FILE_NAME = "src/main/resources/inputFileExample.csv";
    private static FileStorage instance;

    public static FileStorage getInstance() {
        if (instance == null) {
            instance = new FileStorage();
        }
        return instance;
    }

    @Override
    public List<FruitMovement> getTransactionOf(Fruit fruit) {
        if (fruit == null) {
            throw new RuntimeException("Fruit can't be null");
        }
        return movementOfFruits.stream()
                .filter(fruitsMovement -> fruit.equals(fruitsMovement.getFruit()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Fruit> getAllFruits() {
        return movementOfFruits.stream()
                .map(FruitMovement::getFruit)
                .collect(Collectors.toList());
    }

    @Override
    public void saveReport(Map<Fruit, Integer> results) {

    }
}
