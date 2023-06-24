package service;

import java.io.File;
import java.util.List;
import model.FruitTransaction;

public class FruitShopServiceImpl implements FruitShopService {
    private TransactionStrategy transactionStrategy;
    private FileReaderService fileReaderService;
    private FileWriterService fileWriterService;

    public FruitShopServiceImpl(TransactionStrategy transactionStrategy,
                                FileReaderService fileReaderService,
                                FileWriterService fileWriterService) {
        this.transactionStrategy = transactionStrategy;
        this.fileReaderService = fileReaderService;
        this.fileWriterService = fileWriterService;
    }

    public TransactionStrategy getTransactionStrategy() {
        return transactionStrategy;
    }

    public void setTransactionStrategy(TransactionStrategy transactionStrategy) {
        this.transactionStrategy = transactionStrategy;
    }

    public FileReaderService getFileReaderService() {
        return fileReaderService;
    }

    public void setFileReaderService(FileReaderService fileReaderService) {
        this.fileReaderService = fileReaderService;
    }

    public FileWriterService getFileWriterService() {
        return fileWriterService;
    }

    public void setFileWriterService(FileWriterService fileWriterService) {
        this.fileWriterService = fileWriterService;
    }

    @Override
    public void generateDailyReport(File inputFile, File reportFile) {
        List<String> dataFromFile = readFile(inputFile);
        List<FruitTransaction> fruitTransactions = convertData(dataFromFile);
        List<String> reportData = createReport(fruitTransactions);
        File report = writeToFile(reportFile, reportData);
        printReport(report);
    }

    private List<String> readFile(File inputFile) {
        return fileReaderService.readFile(inputFile);
    }

    private List<FruitTransaction> convertData(List<String> data) {
        FruitTransactionConverter converter = new FruitTransactionConverterImpl();
        return converter.convertToFruitTransaction(data);
    }

    private List<String> createReport(List<FruitTransaction> transactions) {
        ReportService reportService = new ReportServiceImpl(transactionStrategy);
        return reportService.createReport(transactions);
    }

    private File writeToFile(File reportFile, List<String> report) {
        return fileWriterService.saveToFile(reportFile, report);
    }

    void printReport(File report) {
        Printer printer = new PrinterImpl();
        printer.print(fileReaderService.readFile(report));
    }
}
