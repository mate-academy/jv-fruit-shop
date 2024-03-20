package core.basesyntax.serviceimpl;

import core.basesyntax.service.FileHandlerCsv;
import java.util.ArrayList;
import java.util.List;

public class FileHandlerCsvImpl implements FileHandlerCsv {
    @Override
    public List<FruitTransaction> parse(List<String> info) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String line : info) {
            String[] operations = line.split(System.lineSeparator());
            for (String operation : operations) {
                String[] data = operation.split(",");
                FruitTransaction fruitBalance = new FruitTransaction();
                fruitBalance.setOperation(getOperation(data[0]));
                fruitBalance.setFruit(data[1]);
                fruitBalance.setQuantity(Integer.parseInt(data[2]));
                fruitTransactions.add(fruitBalance);
            }
        }
        return fruitTransactions;
    }

    private FruitTransaction.Operation getOperation(String operation) {
        if (operation.equals(FruitTransaction.Operation.PURCHASE.getCode())) {
            return FruitTransaction.Operation.PURCHASE;
        } else if (operation.equals(FruitTransaction.Operation.BALANCE.getCode())) {
            return FruitTransaction.Operation.BALANCE;
        } else if (operation.equals(FruitTransaction.Operation.RETURN.getCode())) {
            return FruitTransaction.Operation.RETURN;
        } else if (operation.equals(FruitTransaction.Operation.SUPPLY.getCode())) {
            return FruitTransaction.Operation.SUPPLY;
        }
        return null;
    }
}
