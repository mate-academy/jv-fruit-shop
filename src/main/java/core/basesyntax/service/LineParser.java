package core.basesyntax.service;

import java.util.List;

public interface LineParser<T> {

    List<T> createListOfTransactions(List<String> lines);
}
