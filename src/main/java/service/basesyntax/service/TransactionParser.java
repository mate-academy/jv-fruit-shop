package service.basesyntax.service;

import service.basesyntax.model.FruitTransaction;

public interface TransactionParser {
    FruitTransaction parse(String lines);
}
