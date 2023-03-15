package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.ParserFromCsvService;
import core.basesyntax.service.ReportService;
import core.basesyntax.strategy.BalanceStrategy;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseStrategy;
import core.basesyntax.strategy.ReturnStrategy;
import core.basesyntax.strategy.SupplyStrategy;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_PATH = "src/main/resources/source.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";
    private static final CsvFileReaderService readFromFile = new CsvFileReaderService();
    private static final ParserFromCsvService parseFile = new ParserFromCsvService();
    private static final Map<FruitTransaction.Operation, OperationHandler> getStrategy = Map.of(
            FruitTransaction.Operation.BALANCE, new BalanceStrategy(),
            FruitTransaction.Operation.PURCHASE, new PurchaseStrategy(),
            FruitTransaction.Operation.SUPPLY, new SupplyStrategy(),
            FruitTransaction.Operation.RETURN, new ReturnStrategy()
    );
    private static final OperationStrategy strategy = new OperationStrategy(getStrategy);
    private static final CsvFileWriterService writeToFile = new CsvFileWriterService();
    private static final ReportService reportService = new ReportService();

    public static void main(String[] args) {
        List<String> stringsFromFile = readFromFile.readFromFile(FILE_PATH);
        List<FruitTransaction> fruitTransactions = parseFile.parse(stringsFromFile);

        for (FruitTransaction fruit : fruitTransactions) {
            OperationHandler opHandler = strategy.get(fruit.getOperation());
            opHandler.initializeOperation(fruit);
        }
        String finalReport = reportService.generateReport();
        writeToFile.writeInFile(OUTPUT_FILE_PATH, finalReport);
    }
}
