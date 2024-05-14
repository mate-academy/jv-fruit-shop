package main;

import dao.FruitShopDao;
import dao.FruitShopDaoImpl;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FileReaderService;
import service.FileWriterService;
import service.ReportCreatorService;
import service.TransactionParserService;
import service.impl.BalanceReportCreatorService;
import service.impl.FileReaderServiceImpl;
import service.impl.FileWriterServiceImpl;
import service.impl.TransactionParserServiceImpl;
import strategy.BalanceStrategyImpl;
import strategy.OperationStrategy;
import strategy.operation.BalanceOperationHandler;
import strategy.operation.OperationHandler;
import strategy.operation.PurchaseOperationHandler;
import strategy.operation.ReturnOperationHandler;
import strategy.operation.SupplyOperationHandler;

public class Main {
    private static final String STATISTIC_FILE_PATH = "src/main/resources/"
            + "balance.csv";
    private static final String DATA_FILE_PATH = "src/main/resources/dataBase.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap =
                Map.of(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(),
                        FruitTransaction.Operation.RETURN, new ReturnOperationHandler(),
                        FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(),
                        FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        TransactionParserService parse = new TransactionParserServiceImpl();
        FruitShopDao dao = new FruitShopDaoImpl();
        OperationStrategy strategy = new BalanceStrategyImpl(operationHandlerMap);
        ReportCreatorService reportCreator = new BalanceReportCreatorService();
        FileWriterService fileWriter = new FileWriterServiceImpl();
        List<String> dataFromFile = fileReaderService.read(DATA_FILE_PATH);
        List<FruitTransaction> getAllFruitTransaction = parse.parseFromListStrings(dataFromFile);
        for (FruitTransaction fruitTransaction : getAllFruitTransaction) {
            strategy.getHandler(fruitTransaction).execute(fruitTransaction);
        }
        List<String> balanceReport = reportCreator.getReport(dao.getBalance());
        fileWriter.write(balanceReport, STATISTIC_FILE_PATH);
    }
}
