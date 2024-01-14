package core.basesyntax;

import core.basesyntax.dao.ReadFile;
import core.basesyntax.dao.ReadFileImpl;
import core.basesyntax.process.DataProcess;
import core.basesyntax.report.ReportCreator;
import core.basesyntax.storage.FruitStorage;
import core.basesyntax.storage.FruitTransaction;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.strategy.SupplyHandler;
import core.basesyntax.writereport.ReportWriter;
import core.basesyntax.writereport.WriteReportImpl;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> strategyMap = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceHandler(),
                FruitTransaction.Operation.RETURN, new ReturnHandler(),
                FruitTransaction.Operation.SUPPLY, new SupplyHandler(),
                FruitTransaction.Operation.PURCHASE, new PurchaseHandler()
        );
        String readFilePath = "src/main/resources/file.txt";
        String reportFilePath = "src/main/resources/report.txt";
        FruitStorage fruitStorage = new FruitStorage();
        ReadFile readFileDao = new ReadFileImpl();
        DataProcess dataProcess = new DataProcess();
        dataProcess.addDataToStorage(readFileDao.readFromFile(readFilePath),
                fruitStorage, strategyMap);
        ReportCreator reportCreator = new ReportCreator();
        String report = reportCreator.createReport(fruitStorage.getStorage());
        ReportWriter writeReport = new WriteReportImpl();
        writeReport.writeReportToFile(report, reportFilePath);
    }
}
