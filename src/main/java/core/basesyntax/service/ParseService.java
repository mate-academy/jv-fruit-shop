package core.basesyntax.service;

mport core.basesyntax.model.Transaction;

import java.util.List;

public interface ParseService {
    List<Transaction> transactionsParser(List<String> transactions);
}