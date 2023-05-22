package service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface ParseService {
    List<Transaction> parse(List<String> readDataFromFile);
}
