package service.impl;

import java.util.Arrays;
import model.FruitTransaction;
import service.SplitInformation;

public class SplitInformationImpl implements SplitInformation {
    @Override
    public FruitTransaction addToTransactionList(String information) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        java.lang.String[] s = information.split(",");
        fruitTransaction.setOperation(Arrays.stream(FruitTransaction.Operation.values())
                .filter(o -> o.getOperation().equals(s[0]))
                .findFirst()
                .orElseThrow());
        fruitTransaction.setFruit(s[1]);
        fruitTransaction.setQuantity(Integer.parseInt(s[2]));
        return fruitTransaction;
    }
}
