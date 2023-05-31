package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.imps.FruitServiceImp;
import core.basesyntax.services.imps.ParserServiceImp;
import core.basesyntax.services.imps.ReaderServiceImp;
import core.basesyntax.services.imps.ReportServiceImp;
import core.basesyntax.services.imps.WriterServiceImp;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.strategy.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String SOURCE_FILE_PATH = "src\\main\\resources\\source_file.csv";
    private static final String REPORT_FILE_PATH = "src\\main\\resources\\report_file.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(
                    FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationStrategyMap.put(
                    FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationStrategyMap.put(
                    FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationStrategyMap.put(
                    FruitTransaction.Operation.RETURN, new ReturnHandler());
        List<FruitTransaction> transactions = new ParserServiceImp()
                .parse(new ReaderServiceImp().readFromFile(SOURCE_FILE_PATH));
        new FruitServiceImp(operationStrategyMap).store(transactions);
        new WriterServiceImp()
                .writeToFile(REPORT_FILE_PATH, new ReportServiceImp().createReportString());
    }
}
