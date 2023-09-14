package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportTextGenerator;
import core.basesyntax.service.ReportWriter;
import core.basesyntax.serviceimpl.FileReaderImpl;
import core.basesyntax.serviceimpl.ProcessingImpl;
import core.basesyntax.serviceimpl.ReportGeneratorImpl;
import core.basesyntax.serviceimpl.ReportTextGeneratorImpl;
import core.basesyntax.serviceimpl.ReportWriterImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handler.BalanceOperation;
import core.basesyntax.strategy.handler.PurchaseOperation;
import core.basesyntax.strategy.handler.ReturnOperation;
import core.basesyntax.strategy.handler.SupplyOperation;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BalanceOperation balanceOperation = new BalanceOperation();
        PurchaseOperation purchaseOperation = new PurchaseOperation();
        ReturnOperation returnOperation = new ReturnOperation();
        SupplyOperation supplyOperation = new SupplyOperation();
        FileReaderImpl reportReader = new FileReaderImpl();
        ProcessingImpl dataProcessor = new ProcessingImpl();
        HashMap<Operation, OperationStrategy> operationStrategyHashMap
                = new HashMap<>();
        operationStrategyHashMap.put(Operation.BALANCE, balanceOperation);
        operationStrategyHashMap.put(Operation.PURCHASE, purchaseOperation);
        operationStrategyHashMap.put(Operation.RETURN, returnOperation);
        operationStrategyHashMap.put(Operation.SUPPLY, supplyOperation);
        ReportGenerator reportGenerator = new ReportGeneratorImpl(operationStrategyHashMap);
        ReportWriter reportWriter = new ReportWriterImpl();
        ReportTextGenerator reportTextGenerator = new ReportTextGeneratorImpl();

        List<String> text = reportReader
                .getTextReport("src/main/resources/reports/inputReport.csv");
        List<FruitTransaction> fruitTransactions = dataProcessor.getProcessedData(text);
        reportGenerator.generateReport(fruitTransactions);
        reportWriter.writeReport("outputReport.csv", reportTextGenerator.generateTextReport());
    }
}
