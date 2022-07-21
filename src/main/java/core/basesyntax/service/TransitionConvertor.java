package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface TransitionConvertor {
    List<Transaction> convert(List<String> lines);
}
