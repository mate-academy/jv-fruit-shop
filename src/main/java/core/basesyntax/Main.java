package core.basesyntax;

import core.basesyntax.dao.FileReader;
import core.basesyntax.dao.FileReaderImpl;
import core.basesyntax.dao.FileWriter;
import core.basesyntax.dao.FileWriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.DataConverterImpl;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.OperationsStrategy;
import core.basesyntax.service.OperationsStrategyImpl;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportGeneratorImpl;
import core.basesyntax.service.operation.BalanceOperation;
import core.basesyntax.service.operation.PurchaseOperation;
import core.basesyntax.service.operation.ReturnOperation;
import core.basesyntax.service.operation.SupplyOperation;
import core.basesyntax.storage.Storage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Main <inputCSV> <outputCSV>");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];

        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(inputFile);

        DataConverter dataConverter = new DataConverterImpl();

        Storage storage = new Storage();

        Map<Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.BALANCE, new BalanceOperation(storage));
        operationHandlers.put(Operation.SUPPLY, new SupplyOperation(storage));
        operationHandlers.put(Operation.PURCHASE, new PurchaseOperation(storage));
        operationHandlers.put(Operation.RETURN, new ReturnOperation(storage));

        OperationsStrategy operationStrategy = new OperationsStrategyImpl(operationHandlers);

        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.getHandler(transaction.getOperation());
            handler.handle(transaction);
        }

        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        String resultingReport = reportGenerator.getReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, "finalReport.csv");

        System.out.println("Отчёт успешно сгенерирован и записан в finalReport.csv");
    }
}
