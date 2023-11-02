package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.services.FruitMapper;
import core.basesyntax.services.ReportService;
import core.basesyntax.services.reads.CsvFileReader;
import core.basesyntax.services.reads.CsvFileReaderImpl;
import core.basesyntax.services.writes.CsvFileWriterOrder;
import core.basesyntax.services.writes.CsvFileWriterOrderImpl;
import core.basesyntax.transactions.OperationHandler;
import core.basesyntax.transactions.OperationStrategy;
import core.basesyntax.transactions.impl.BalanceOperationHandler;
import core.basesyntax.transactions.impl.PurchaseOperationHandler;
import core.basesyntax.transactions.impl.ReturnOperationHandler;
import core.basesyntax.transactions.impl.SupplyOperationHandler;
import java.util.List;
import java.util.Map;

public class FruitShopApp {
    public static final String INPUT_PATH = "Input target transactions";
    public static final String OUTPUT_FILE_REPORT = "Report on the results";

    public static void main(String[] args) {
        CsvFileReader readFile = new CsvFileReaderImpl();
        List<String> readAllLines = readFile.read(INPUT_PATH);
        FruitMapper fruitMap = new FruitMapper();
        List<FruitTransaction> fruitTransactions = fruitMap.mapData(readAllLines);

        Map<Operation, OperationHandler> transactionStrategies = Map.of(
                Operation.BALANCE, new BalanceOperationHandler(),
                Operation.SUPPLY, new SupplyOperationHandler(),
                Operation.PURCHASE, new PurchaseOperationHandler(),
                Operation.RETURN, new ReturnOperationHandler()
        );

        OperationStrategy operationStrategy = new OperationStrategy(transactionStrategies);
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            operationStrategy.handler(fruitTransaction);
        }
        ReportService report = new ReportService();

        String generateReport = report.generateReport(Storage.STORAGE_VALUE);
        CsvFileWriterOrder fileWriterCsv = new CsvFileWriterOrderImpl();
        fileWriterCsv.writerOrder(generateReport, OUTPUT_FILE_REPORT);
    }
}
