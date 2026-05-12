package core.basesyntax.parser;

import core.basesyntax.transaction.FruitTransaction;
import java.util.stream.Stream;

public interface DataConverter {
    Stream<FruitTransaction> convertToTransaction(Stream<String> strings);
}
