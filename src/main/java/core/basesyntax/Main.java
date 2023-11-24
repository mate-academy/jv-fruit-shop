package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.InputConverterService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionStrategyService;
import core.basesyntax.service.impl.CsvFileReaderService;
import core.basesyntax.service.impl.CsvFileWriterService;
import core.basesyntax.strategy.BalanceTransactionService;
import core.basesyntax.strategy.PurchaseTransactionService;
import core.basesyntax.strategy.ReturnTransactionService;
import core.basesyntax.strategy.SupplyTransactionService;
import core.basesyntax.strategy.TransactionService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input_data.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output_data.csv";
    private static final Map<FruitTransaction.Operation,
            TransactionService> strategies = new HashMap<>();

    public static void main(String[] args) {
        strategies.put(FruitTransaction.Operation.BALANCE, new BalanceTransactionService());
        strategies.put(FruitTransaction.Operation.SUPPLY, new SupplyTransactionService());
        strategies.put(FruitTransaction.Operation.PURCHASE, new PurchaseTransactionService());
        strategies.put(FruitTransaction.Operation.RETURN, new ReturnTransactionService());

        FileReaderService readerService = new CsvFileReaderService();
        List<String[]> data = readerService.readFile(INPUT_FILE_PATH);
        InputConverterService inputConverter = new InputConverterService();
        List<FruitTransaction> transactions = inputConverter.convertToTransactions(data);
        TransactionStrategyService strategy = new TransactionStrategyService(strategies);
        for (FruitTransaction transaction : transactions) {
            TransactionService transactionService = strategy.getTransactionService(transaction);
            transactionService.process(transaction);
        }
        ReportService reportService = new ReportService();
        List<String[]> report = reportService.createReport();
        FileWriterService output = new CsvFileWriterService();
        output.writeToFile(OUTPUT_FILE_PATH, report);
    }
}
