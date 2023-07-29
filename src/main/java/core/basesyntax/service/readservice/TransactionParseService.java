package core.basesyntax.service.readservice;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionParseService {
    List<FruitTransaction> parse(String dataFromCsvFile);
}
