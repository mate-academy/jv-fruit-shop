package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface ConverterService {
    List<Transaction> convertFromString(List<String> cvsLines);
}
