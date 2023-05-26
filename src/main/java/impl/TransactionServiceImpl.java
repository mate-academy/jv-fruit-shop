package impl;

import java.util.List;
import model.FruitTransaction;
import service.OperationStrategy;
import service.ParseService;
import service.ReadService;
import service.ReportService;
import service.WriteService;
import strategy.OperationHandler;

public class TransactionServiceImpl {
    private OperationStrategy operationStrategy;
    private ReadService readService;
    private ParseService parseService;
    private ReportService reportService;
    private WriteService writeService;

    public TransactionServiceImpl(OperationStrategy operationStrategy, ReadService readService,
                                  ParseService parseService, ReportService reportService,
                                  WriteService writeService) {
        this.operationStrategy = operationStrategy;
        this.readService = readService;
        this.parseService = parseService;
        this.reportService = reportService;
        this.writeService = writeService;
    }

    public void processTransactions() {
        List<String> dataFromFile = readService.read("src/main/java/database.csv");
        List<FruitTransaction> fruitTransactions = parseService.parse(dataFromFile);

        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationHandler operationHandler =
                    operationStrategy.get(fruitTransaction.getOperation());
            operationHandler.operate(fruitTransaction);
        }

        String report = reportService.createReport();
        writeService.writeToFile("src/main/java/report.csv", report);
    }
}
