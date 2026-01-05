package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface DataConverter {
    public Transaction convert(String lines);

    public List<Transaction> convert(List<String> lines);
}
