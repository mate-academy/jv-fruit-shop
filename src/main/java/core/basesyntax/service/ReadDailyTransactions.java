package core.basesyntax.service;

import core.basesyntax.db.DataBase;
import core.basesyntax.db.DataBaseCsvImpl;
import java.util.ArrayList;
import java.util.List;

public class ReadDailyTransactions {
    public static final String TRANSACTION_FULL_PATH = "src/main/resources/transaction.csv";
    public static final String HEAD_OF_TRANSACTION_TABLE = "type,fruit,quantity";

    private List<String> listOfTransactions = new ArrayList<>();

    public ReadDailyTransactions() {

    }

    public List<String> getListOfTransactions() {
        DataBase transactionFileConnection = new DataBaseCsvImpl(TRANSACTION_FULL_PATH);
        return transactionFileConnection.getDataFromFile();
    }
}
