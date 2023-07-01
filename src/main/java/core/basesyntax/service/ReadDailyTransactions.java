package core.basesyntax.service;

import core.basesyntax.db.DataBase;
import core.basesyntax.db.DataBaseCsvImpl;
import java.util.ArrayList;
import java.util.List;

public class ReadDailyTransactions {
    public static final String HEAD_OF_TRANSACTION_TABLE = "type,fruit,quantity";
    private final String transactionFullPath;

    private List<String> listOfTransactions = new ArrayList<>();

    public ReadDailyTransactions(String transactionFullPath) {
        this.transactionFullPath = transactionFullPath;
    }

    public List<String> getListOfTransactions() {
        DataBase transactionFileConnection = new DataBaseCsvImpl(transactionFullPath);
        return transactionFileConnection.getDataFromFile();
    }
}
