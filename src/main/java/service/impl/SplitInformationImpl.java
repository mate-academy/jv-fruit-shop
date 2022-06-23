package service.impl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.SplitInformation;

public class SplitInformationImpl implements SplitInformation {
    private static final int FIRST_ELEMENT_FROM_LINE = 0;
    private static final int SECOND_ELEMENT_FROM_LINE = 1;
    private static final int THIRD_ELEMENT_FROM_LINE = 2;

    @Override
    public List<FruitTransaction> createTransactionList(List<String> info) {
        info.remove(0);
        return info.stream()
                .map(this::splitInfo)
                .collect(Collectors.toList());
    }
    
    private FruitTransaction splitInfo(String information) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] s = information.split(",");
        fruitTransaction.setOperation(
                fruitTransaction.setValueForOperation(s[FIRST_ELEMENT_FROM_LINE]));
        fruitTransaction.setFruit(s[SECOND_ELEMENT_FROM_LINE]);
        fruitTransaction.setQuantity(Integer.parseInt(s[THIRD_ELEMENT_FROM_LINE]));
        return fruitTransaction;
    }
}
