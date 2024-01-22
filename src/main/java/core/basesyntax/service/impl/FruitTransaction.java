package core.basesyntax.service.impl;

import java.util.List;

public interface FruitTransaction {

    List<String> processBalance();

    List<String> processPurchase();

    List<String> processReturn();

    List<String> processSupply();
}
