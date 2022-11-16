package core.basesyntax;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.IStorageService;
import core.basesyntax.service.StorageService;
import core.basesyntax.strategy.FruitStrategy;
import core.basesyntax.strategy.IFruitStrategy;
import java.util.HashMap;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        Map<String, FruitTransaction.Operation> listOperations = new HashMap<>();
        listOperations.put("b", FruitTransaction.Operation.BALANCE);
        listOperations.put("s", FruitTransaction.Operation.SUPPLY);
        listOperations.put("p", FruitTransaction.Operation.PURCHASE);
        listOperations.put("r", FruitTransaction.Operation.RETURN);
        IFruitStrategy fruitStrategy = new FruitStrategy(listOperations);
        IStorageService storageService = new StorageService();
        FruitTransaction fruitTransaction = fruitStrategy.chooseOperation("b", "banana", 150);
        storageService.operation(fruitTransaction);
        fruitTransaction = fruitStrategy.chooseOperation("b", "banana", 150);
        storageService.operation(fruitTransaction);
        fruitTransaction = fruitStrategy.chooseOperation("b","banana",20);
        storageService.operation(fruitTransaction);
        fruitTransaction = fruitStrategy.chooseOperation("b","apple",100);
        storageService.operation(fruitTransaction);
        fruitTransaction = fruitStrategy.chooseOperation("p","banana",13);
        storageService.operation(fruitTransaction);
        fruitTransaction = fruitStrategy.chooseOperation("r","apple",10);
        storageService.operation(fruitTransaction);
        fruitTransaction = fruitStrategy.chooseOperation("p","apple",20);
        storageService.operation(fruitTransaction);
        fruitTransaction = fruitStrategy.chooseOperation("s","banana",50);
        storageService.operation(fruitTransaction);
    }
}
