package core.basesyntax;

import core.basesyntax.dao.BalanceDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Product;
import core.basesyntax.service.BalanceService;
import core.basesyntax.service.BalanceServiceImpl;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String BALANCE_FILE_NAME = "src/main/resources/database.csv";
    private static final String PIVOT_FILE_NAME = "src/main/resources/pivot.csv";

    public static void main(String[] args) {

        BalanceService balanceService
                = new BalanceServiceImpl(new OperationStrategyImpl());

        //1 Read data from CSV file
        Storage storage = new Storage(new BalanceDaoImpl().getBalanceFromFile(BALANCE_FILE_NAME));

        //2 Process this data
        Map<Product, Integer> balance = balanceService.getBalance(storage.getTransactions());

        //3 Generate a report on processed data
        List<String> balanceReport = balanceService.makeBalanceReport(balance);

        //4 Write report to new file
        balanceService.exportPivotToFile(PIVOT_FILE_NAME, balanceReport);
    }
}
