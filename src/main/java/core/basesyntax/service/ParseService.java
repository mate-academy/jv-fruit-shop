package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

/**
 * Interface responsible for parsing CSV data into a list of FruitTransaction objects.
 Contains a method List FruitTransaction parseDataToTransaction(List String data)
 that takes a list of strings (CSV data) and converts it
 into a list of FruitTransaction objects.**/
public interface ParseService {
    List<FruitTransaction> parseDataToTransaction(List<String> data);
}
