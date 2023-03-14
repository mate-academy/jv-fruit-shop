package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessService;
import java.util.List;
import java.util.stream.Collectors;

public class ProcessServiceImpl implements ProcessService {

    @Override
    public List<FruitTransaction> getTransactions(List<String> lines) {
        final int skipFirstLine = 1;
        return lines.stream()
                .skip(skipFirstLine)
                .map(s -> transformation(s))
                .collect(Collectors.toList());

    }

    private FruitTransaction transformation(String line) {
        final String comma = ",";
        final int typeAction = 0;
        final int fruit = 1;
        final int amountOfFruit = 2;

        String[] lineSplit = line.split(comma);
        return new FruitTransaction(FruitTransaction.Operation
                .getOperationByCode(lineSplit[typeAction]),
                lineSplit[fruit], Integer.parseInt(lineSplit[amountOfFruit]));
    }
}
