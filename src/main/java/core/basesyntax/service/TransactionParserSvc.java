package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface TransactionParserSvc {
    List<FruitTransaction> parse(List<String> fileData);
}
