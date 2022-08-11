package core.basesyntax;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CreateReport;
import core.basesyntax.service.DataProcessing;
import core.basesyntax.service.ReportWriter;
import core.basesyntax.service.impl.CreateReportImpl;
import core.basesyntax.service.impl.DataProcessingImpl;
import core.basesyntax.service.impl.ReaderServiceCsvImpl;
import core.basesyntax.service.impl.ReportWriterImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operations.BalanceOperation;
import core.basesyntax.strategy.operations.OperationHandler;
import core.basesyntax.strategy.operations.PurchaseOperation;
import core.basesyntax.strategy.operations.ReturnOperation;
import core.basesyntax.strategy.operations.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperation());

        ReaderServiceCsvImpl readerServiceCsv = new ReaderServiceCsvImpl();
        FruitsDao fruitsDao = new FruitsDaoImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        DataProcessing dataProcessing = new DataProcessingImpl(fruitsDao, operationStrategy);
        CreateReport newReport = new CreateReportImpl(fruitsDao);
        ReportWriter writer = new ReportWriterImpl();

        List<FruitTransaction> fileInput = readerServiceCsv.read("src/main/resources/input.csv");
        dataProcessing.run(fileInput);
        String report = newReport.get();
        writer.writeToFile(report, "src/main/resources/output.csv");

        System.out.println(report);
    }
}
