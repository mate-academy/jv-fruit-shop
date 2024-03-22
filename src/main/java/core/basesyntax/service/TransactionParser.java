package core.basesyntax.service;

import core.basesyntax.dto.ProductTransaction;
import java.util.List;

public interface TransactionParser {
    List<ProductTransaction> parseTransactions(List<String> data);
}
