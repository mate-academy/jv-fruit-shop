package mate.academy.service.impl;

import mate.academy.dao.ShopDaoImpl;
import mate.academy.model.FruitTransaction;
import mate.academy.service.ParseFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParseFileImpl implements ParseFile {
    private static final int INDEX_TYPE_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;
    private final ShopDaoImpl shopDaoCsv = new ShopDaoImpl();

    public List<FruitTransaction> parseFile() {
        List<String> records = shopDaoCsv.readFromDb();
        List<FruitTransaction> fruitTransactions = records.stream()
                .skip(1)
                .map(line -> line.trim().split(","))
                .map(splittedLine -> new FruitTransaction(splittedLine[INDEX_TYPE_OPERATION],
                                                          splittedLine[INDEX_FRUIT],
                                                          Integer.parseInt(splittedLine[INDEX_QUANTITY])))
                .collect(Collectors.toList());
        List<String> listOfTypeOperations = new ArrayList<>();
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            listOfTypeOperations.add(operation.getOperations());
        }
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            if (!listOfTypeOperations.contains(fruitTransaction.getOperation())) {
                throw new RuntimeException("Unknown type operation");
            }
            if (fruitTransaction.getQuantity() < 0) {
                throw new RuntimeException("Quantity must be greater then 0");
            }
        }

        return fruitTransactions;
    }

}
