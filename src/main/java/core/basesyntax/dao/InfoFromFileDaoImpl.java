package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class InfoFromFileDaoImpl implements InfoFromFileDao{
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> getAllTransactionsFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            var collect = reader
                    .lines()
                    .map(l -> {
                        String[] transactionInArray = l.split(",");
                        FruitTransaction.Operation operation =
                                defineOperationType(transactionInArray[OPERATION_INDEX]);
                        int quantity = Integer.parseInt(transactionInArray[QUANTITY_INDEX]);
                        return new FruitTransaction(operation, transactionInArray[FRUIT_INDEX],
                                quantity);
                    })
                    .collect(Collectors.toList());
            return collect;
        } catch (IOException e) {
            throw new RuntimeException("Something wrong with file with name " + fileName);
        }
    }

    private FruitTransaction.Operation defineOperationType(String type) {
        switch (type){
            case "b":
                return FruitTransaction.Operation.BALANCE;
            case "p":
                return FruitTransaction.Operation.PURCHASE;
            case "s":
                return FruitTransaction.Operation.SUPPLY;
            case "r":
                return FruitTransaction.Operation.RETURN;
            default:
                return FruitTransaction.Operation.SUPPLY;
        }
    }
}
