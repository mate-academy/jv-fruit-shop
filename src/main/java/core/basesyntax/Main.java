package core.basesyntax;

import core.basesyntax.dao.PivotDaoImpl;
import core.basesyntax.dao.TransactionDaoImpl;
import core.basesyntax.service.BalanceService;
import core.basesyntax.service.BalanceServiceImpl;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        BalanceService balanceService = new BalanceServiceImpl(new TransactionDaoImpl(),
                                            new PivotDaoImpl(), new OperationStrategyImpl());

        //1 Read data from CSV file
        balanceService.getTransactionsFromFile();

        //2 Process this data
        balanceService.calculateBalance();

        //3 Generate a report on processed data
        List<String> reportList = balanceService.makeBalanceReport();

        //4 Write report to new file
        balanceService.exportPivotToFile(reportList);
    }
}
