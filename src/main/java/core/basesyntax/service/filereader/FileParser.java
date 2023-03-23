package core.basesyntax.service.filereader;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FileParser {
    List<FruitTransaction> parsedFruitTransactions(List<String> fruitsTransactions);
}
