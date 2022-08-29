package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.TypeActivity;
import core.basesyntax.service.ParseFruitTransaction;
import core.basesyntax.service.ParseTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class ParseTransactionImpl implements ParseTransaction {
    private final ParseFruitTransaction parseFruitTransaction;

    public ParseTransactionImpl(ParseFruitTransaction parseFruitTransaction) {
        this.parseFruitTransaction = parseFruitTransaction;
    }

    @Override
    public List<FruitTransaction> processing(List<String> list) {
        return list.stream()
                .filter(l -> l != null && TypeActivity.getByLabel(l.substring(0,1)) != null)
                .map(parseFruitTransaction::processing)
                .collect(Collectors.toList());
    }
}
