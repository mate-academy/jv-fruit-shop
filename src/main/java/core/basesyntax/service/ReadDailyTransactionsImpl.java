package core.basesyntax.service;

import core.basesyntax.db.DataBase;
import core.basesyntax.db.DataBaseCsvImpl;
import java.util.List;

public class ReadDailyTransactionsImpl implements ReadDailyTransactions {
    public static final String HEAD_OF_TRANSACTION_TABLE = "type,fruit,quantity";

    public List<String> getListOfTransactions(String transactionFullPath) {
        DataBase transactionFileConnection = new DataBaseCsvImpl(transactionFullPath);
        return transactionFileConnection.getDataFromFile();
    }
}
