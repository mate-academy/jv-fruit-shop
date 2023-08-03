package core.service;

import core.model.FruitTransaction;

import java.util.List;

public interface TransactionParser {
    List<FruitTransaction> parseData(List<String> data);
}
