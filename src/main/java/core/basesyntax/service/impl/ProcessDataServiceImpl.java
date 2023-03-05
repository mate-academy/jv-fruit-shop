package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ProcessDataImpl implements ProcessData {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> create(List<String> list) {
        List<FruitTransaction> transactionList = new ArrayList<>();
        list.remove(0);

        for (String transaction : list) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] line = transaction.split(",");
            String charOperation = line[OPERATION_TYPE_INDEX].trim();
            fruitTransaction.setOperation(getOperation(charOperation));
            fruitTransaction.setFruit(line[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(line[QUANTITY_INDEX]));
            transactionList.add(fruitTransaction);
        }
//        list
//                .stream()
//                .skip(1)
//                .flatMap(d -> Stream.of(d.split(",")))
//                .map(f -> f[])
        return transactionList;
    }

    private FruitTransaction.Operation getOperation(String str) {
        return Arrays.stream(FruitTransaction.Operation.values())
                .filter(s -> s.getCode().equals(str))
                .findFirst()
                .orElseThrow(()->new RuntimeException("wrong operator index"));
    }
}
