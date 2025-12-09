package core.basesyntax;

import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/result.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperation(),
                FruitTransaction.Operation.SUPPLY, new SupplyOperation(),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperation(),
                FruitTransaction.Operation.RETURN, new ReturnOperation()
        );

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        ShopService shopService = new ShopServiceImpl(operationStrategy);

        FileReader fileReader = new FileReaderImpl();
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        FileWriter fileWriter = new FileWriterImpl();

        List<FruitTransaction> transactions = List.of(
                new FruitTransaction(FruitTransaction.Operation.BALANCE, "banana", 123),
                new FruitTransaction(FruitTransaction.Operation.SUPPLY, "apple", 222),
                new FruitTransaction(FruitTransaction.Operation.PURCHASE, "plum", 33)
        );
        shopService.process(transactions);

        String report = reportGenerator.getReport();

        fileWriter.output(report, OUTPUT_FILE_PATH);

        System.out.println("Processing finished. Report written to: " + OUTPUT_FILE_PATH);
    }
}
