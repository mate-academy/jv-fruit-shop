package core.basesyntax.service;

import core.basesyntax.model.Transaction;

import java.util.List;

public interface ParseService {
    List<Transaction> parseLine(List<String> lines);
}
