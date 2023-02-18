package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface ConverterService {
    List<Transaction> convertFromStringToFunction(List<String> transaction);
}
