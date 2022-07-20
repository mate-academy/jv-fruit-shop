package core.basesyntax;

import core.basesyntax.model.Product;
import core.basesyntax.service.BalanceFileReaderServiceImpl;
import core.basesyntax.service.BalanceService;
import core.basesyntax.service.BalanceServiceImpl;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        BalanceService balanceService = new BalanceServiceImpl(new OperationStrategyImpl());

        //1 Read data from CSV file
        new BalanceFileReaderServiceImpl().getTransactionsFromFile();

        //2 Process this data
        Map<Product, Integer> productBalance = balanceService.calculateBalance();

        //3 Generate a report on processed data
        List<String> reportList = new ReportServiceImpl().makeBalanceReport(productBalance);

        //4 Write report to new file
        new PivotFileWriterServiceImpl().exportPivotToFile(reportList);
    }
}
