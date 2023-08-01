package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;

public interface TransactionParser {
    ArrayList<FruitTransaction> parseCsvRow(ArrayList<String> csvRowList);
}
