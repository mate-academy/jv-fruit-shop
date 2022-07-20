package core.basesyntax;

import core.basesyntax.dao.FileWriterImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.TransactionsFileReaderServiceImpl;
import core.basesyntax.service.BalanceService;
import core.basesyntax.service.BalanceServiceImpl;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        BalanceService balanceService = new BalanceServiceImpl(new OperationStrategyImpl());

        //1 Read data from CSV file
        List<Transaction> transactionsFromFile =
                new TransactionsFileReaderServiceImpl().getTransactionsFromFile();

        //2 Process this data
        Storage.fruits.addAll(balanceService.calculateBalance(transactionsFromFile));

        //3 Generate a report on processed data
        String report = new ReportServiceImpl().makeReport(Storage.fruits);

        //4 Write report to new file
        new FileWriterImpl().writeToFile(report);
    }
}
