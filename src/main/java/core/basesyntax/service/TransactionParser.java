package core.basesyntax.service;

import java.util.List;

public interface TransactionParser {
    List<String[]> parseInputDate(List<String> listOfOperations);
}
