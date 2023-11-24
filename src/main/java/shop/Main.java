package shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import shop.model.FruitTransaction;
import shop.service.FileReaderService;
import shop.service.FileWriterService;
import shop.service.InputConverterService;
import shop.service.ReportService;
import shop.service.TransactionStrategyService;
import shop.service.impl.CsvFileReaderService;
import shop.service.impl.CsvFileWriterService;
import shop.strategy.BalanceTransactionService;
import shop.strategy.PurchaseTransactionService;
import shop.strategy.ReturnTransactionService;
import shop.strategy.SupplyTransactionService;
import shop.strategy.TransactionService;

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
