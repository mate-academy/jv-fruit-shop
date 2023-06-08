package core.basesyntax;

import java.util.List;
import java.util.Map;

public class FruitStoreManager {
    private final CsvFileReaderService readerService;
    private final CsvFileWriterService writerService;
    private final FruitBalanceProcessor balanceProcessor;
    private final FruitReportGenerator reportGenerator;

    public FruitStoreManager(CsvFileReaderService readerService,
                             CsvFileWriterService writerService) {
        this.readerService = readerService;
        this.writerService = writerService;
        this.balanceProcessor = new FruitBalanceProcessor();
        this.reportGenerator = new FruitReportGenerator();
    }

    public void processTransactionsAndGenerateReport(String inputFilePath, String reportFilePath) {
        List<FruitTransaction> transactions = readerService.readTransactions(inputFilePath);
        Map<String, Integer> fruitBalance = balanceProcessor.calculateFruitBalance(transactions);
        List<String> report = reportGenerator.generateReport(fruitBalance);
        writerService.writeReport(report, reportFilePath);
        System.out.println("Report generated successfully!");
    }
}
