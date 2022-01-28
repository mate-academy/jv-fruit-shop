package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcess;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataProcessImpl implements DataProcess {
    @Override
    public List<FruitTransaction> dataProcessing(List<String> fileData) {
        return IntStream.range(0, fileData.size())
                .filter(i -> i != 0)
                .mapToObj(i -> fileData.get(i).split(","))
                .map(this::createObj)
                .collect(Collectors.toList());
    }

    private FruitTransaction createObj(String[] stringsArray) {
        FruitTransaction fruitTransaction = new FruitTransaction(stringsArray[1],
                Integer.parseInt(stringsArray[2]));
        fruitTransaction.setOperationByIndex(stringsArray[0]);
        return fruitTransaction;
    }
}
