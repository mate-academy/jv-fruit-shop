package core.basesyntax.parser;

import core.basesyntax.model.FruitTransaction;

public interface TextLineParser {
    FruitTransaction extractTransaction(String line);
}
