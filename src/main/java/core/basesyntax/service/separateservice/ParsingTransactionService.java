package core.basesyntax.service.separateservice;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParsingTransactionService {
    void parsingTransaction(List<FruitTransaction> dataFromFile, String value);

}
