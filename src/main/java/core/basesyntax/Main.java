package core.basesyntax;

import core.basesyntax.dao.ReadFile;
import core.basesyntax.dao.ReadFileImpl;
import core.basesyntax.process.DataProcess;
import core.basesyntax.report.ReportCreator;
import core.basesyntax.storage.FruitTransaction;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.strategy.SupplyHandler;
import core.basesyntax.strategyhandler.StrategyHandler;
import core.basesyntax.strategyhandler.StrategyHandlerImpl;
import core.basesyntax.writereport.FileWriter;
import core.basesyntax.writereport.WriteReportImpl;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String READ_FILE_PATH = "src/main/resources/file.txt";
    public static final String REPORT_FILE_PATH = "src/main/resources/report.txt";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> strategyMap = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceHandler(),
                FruitTransaction.Operation.RETURN, new ReturnHandler(),
                FruitTransaction.Operation.SUPPLY, new SupplyHandler(),
                FruitTransaction.Operation.PURCHASE, new PurchaseHandler()
        );
        ReadFile readFile = new ReadFileImpl();

        DataProcess dataProcess = new DataProcess();
        List<FruitTransaction> fruitTransactions
                = dataProcess.addDataToStorage(readFile.readFromFile(READ_FILE_PATH));
        StrategyHandler strategyHandler = new StrategyHandlerImpl();
        strategyHandler.strategyHandler(strategyMap, fruitTransactions);
        ReportCreator reportCreator = new ReportCreator();
        String report = reportCreator.createReport();
        FileWriter fileWriter = new WriteReportImpl();
        fileWriter.writeToFile(report, REPORT_FILE_PATH);
    }
}
