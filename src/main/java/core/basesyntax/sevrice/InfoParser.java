package core.basesyntax.sevrice;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface InfoParser {

    List<FruitTransaction> parseToFruitTransactionList(List<String> dataFromFile);
}
