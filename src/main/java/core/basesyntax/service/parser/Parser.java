package core.basesyntax.service.parser;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface Parser {
    List<FruitTransaction> parseStringToFruitTransaction(List<String> allLines);
}
