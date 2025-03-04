package core.basesyntax;

import model.FruitTransaction;
import service.*;
import service.impl.*;
import strategy.BalanceOperation;
import strategy.PurchaseOperation;
import strategy.ReturnOperation;
import strategy.SupplyOperation;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] arg) throws IOException {
        String input = "src/main/resources/reportToRead.csv";
        String output = "src/main/resources/finalReport.csv";

        FileReader fileReader = new FileReaderImpl();
        DataConverter dataConverter = new DataConverterImpl();
        FileWriter fileWriter = new FileWriterImpl();
        ReportGenerator reportService = new ReportGeneratorImpl();

        Map<FruitTransaction.Operation, OperationHandler> strategy = new HashMap<>();
        strategy.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        strategy.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        strategy.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        strategy.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(strategy);

        List<String> readingFile = fileReader.read(input);
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(readingFile);

        for (FruitTransaction transaction : transactions) {
            OperationHandler operationHandler = operationStrategy.get(transaction.getOperation());
            operationHandler.apply(transaction);
        }

        String report = reportService.getReport();
        fileWriter.write(output, report);

        System.out.println(report);
    }
}
