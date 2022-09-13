package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface TransactionParseService {
    List<Transaction> parser(List<String> data);
}
