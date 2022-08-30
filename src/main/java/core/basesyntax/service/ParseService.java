package core.basesyntax.service;


import model.Transaction;

import java.util.List;

public interface ParseService {
    List<Transaction> transactionsParser(List<String> transactions);
}