package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface TransactionConvertor {
    List<Transaction> convert(List<String> lines);
}
