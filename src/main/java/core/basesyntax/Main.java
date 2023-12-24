package core.basesyntax;

import core.basesyntax.dao.ReadReportImpl;
import core.basesyntax.dao.WriteBalanceImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.service.ConvertDataImpl;
import core.basesyntax.service.CreateBalanceImpl;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.ProcessingImpl;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        Storage.storage.put("apple", 0);
        Storage.storage.put("banana", 0);

        ReadReportImpl readData = new ReadReportImpl();

        ConvertDataImpl convertData = new ConvertDataImpl();
        ArrayList<FruitTransaction> fruitTransactionList = convertData.convert(readData.read());
        ProcessingImpl processing = new ProcessingImpl();
        processing.makeTransaction(fruitTransactionList);
        CreateBalanceImpl createBalance = new CreateBalanceImpl();
        String balance = createBalance.createReport();

        WriteBalanceImpl writeBalance = new WriteBalanceImpl();
        writeBalance.write(balance);
    }
}
