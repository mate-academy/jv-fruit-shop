package core.basesyntax.parser;

import core.basesyntax.model.FruitTransaction;

public interface TextLineParser {
    FruitTransaction extractOperationType(String line);
}
