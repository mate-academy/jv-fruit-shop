package core.basesyntax.converter.storage;

import core.basesyntax.converter.ConverterImpl;
import core.basesyntax.converter.ConverterService;
import core.basesyntax.filereader.storage.StringLinesStorage;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class TransactionsStorage {

    public List<FruitTransaction> getTransactionsList() {
        ConverterService converterService = new ConverterImpl();

        return converterService.convertStringToTransaction(StringLinesStorage.stringLines);
    }
}
