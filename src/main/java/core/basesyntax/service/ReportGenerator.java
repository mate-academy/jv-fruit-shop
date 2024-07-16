package core.basesyntax.service;

import core.basesyntax.db.FruitTransaction;
import java.util.List;

public interface ReportGenerator {
    List<FruitTransaction> generateReport(List<FruitTransaction> listOfBalance,
                                          List<FruitTransaction> listOfSupply,
                                          List<FruitTransaction> listOfPurchase,
                                          List<FruitTransaction> listOfReturn);
}
