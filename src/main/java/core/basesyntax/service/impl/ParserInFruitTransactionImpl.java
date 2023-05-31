package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserInFruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class ParserInFruitTransactionImpl implements ParserInFruitTransaction {
    @Override
    public List<FruitTransaction> parseData(List<String> data) {
        data.remove(0);
        return data.stream()
                .map(this::parseRow)
                .collect(Collectors.toList());
    }

    private FruitTransaction parseRow(String row) {
        String[] separateRow = row.split(",");
        return new FruitTransaction(FruitTransaction.Operation.getOperation(separateRow[0]),
                separateRow[1],
                Integer.parseInt(separateRow[2]));
    }
}
