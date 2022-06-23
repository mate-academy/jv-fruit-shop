package service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.ReadTransactions;
import service.SplitInformation;

public class SplitInformationImpl implements SplitInformation {
    private static final int FIRST_ELEMENT_FROM_LINE = 0;
    private static final int SECOND_ELEMENT_FROM_LINE = 1;
    private static final int THIRD_ELEMENT_FROM_LINE = 2;
    private ReadTransactions readTransactions;
    private String path;

    public SplitInformationImpl(ReadTransactions readTransactions, String path) {
        this.readTransactions = readTransactions;
        this.path = path;
    }

    @Override
    public List<FruitTransaction> createTransactionList(List<String> info) {
        info.remove(0);
        return info.stream()
                .map(this::splitInfo)
                .collect(Collectors.toList());
    }
    
    private FruitTransaction splitInfo(String information) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        java.lang.String[] s = information.split(",");
        fruitTransaction.setOperation(Arrays.stream(FruitTransaction.Operation.values())
                .filter(o -> o.getOperation().equals(s[FIRST_ELEMENT_FROM_LINE]))
                .findFirst()
                .orElseThrow());
        fruitTransaction.setFruit(s[SECOND_ELEMENT_FROM_LINE]);
        fruitTransaction.setQuantity(Integer.parseInt(s[THIRD_ELEMENT_FROM_LINE]));
        return fruitTransaction;
    }
}
