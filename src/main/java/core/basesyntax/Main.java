package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FruitShopService;
import service.ReadDataService;
import service.ReportGeneratorService;
import service.TransactionParserService;
import service.WriteReportService;
import service.impl.FruitShopServiceImpl;
import service.impl.ReadDataServiceImpl;
import service.impl.ReportGeneratorServiceImpl;
import service.impl.TransactionParserServiceImpl;
import service.impl.WriteReportServiceImpl;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.impl.BalanceOperationHandler;
import strategy.impl.OperationStrategyImpl;
import strategy.impl.PurchaseOperationHandler;
import strategy.impl.ReturnOperationHandler;
import strategy.impl.SupplyOperationHandler;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/inputFile.csv";
    private static final String REPORT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);

        ReadDataService readData = new ReadDataServiceImpl();
        TransactionParserService transactionParser = new TransactionParserServiceImpl();

        final List<String> read = readData.read(INPUT_FILE);
        final List<FruitTransaction> parse = transactionParser.parse(read);
        fruitShopService.calculate(parse);

        ReportGeneratorService reportGenerate = new ReportGeneratorServiceImpl();
        WriteReportService writeReport = new WriteReportServiceImpl();

        String report = reportGenerate.createMessage();
        writeReport.writeReport(report, REPORT_FILE);
    }
}
