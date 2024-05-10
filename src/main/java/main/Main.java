package main;

import dao.FruitShopDao;
import dao.FruitShopDaoImpl;
import java.util.List;
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

public class Main {
    private static final String STATISTIC_FILE_PATH = "src/main/resources/"
            + "balance.csv";
    private static final String DATA_FILE_PATH = "src/main/resources/dataBase.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> dataFromFile = fileReaderService.read(DATA_FILE_PATH);
        TransactionParserService parse = new TransactionParserServiceImpl();
        FruitShopDao dao = new FruitShopDaoImpl();
        for (String transaction : dataFromFile) {
            dao.add(parse.parseFromString(transaction));
        }
        OperationStrategy strategy = new BalanceStrategyImpl();
        List<FruitTransaction> getAllFruitTransaction = dao.getAll();
        for (FruitTransaction fruitTransaction : getAllFruitTransaction) {
            strategy.getHandler(fruitTransaction).execute(fruitTransaction);
        }
        ReportCreatorService reportCreator = new BalanceReportCreatorService();
        List<String> balanceReport = reportCreator.getReport(dao.getBalance());
        FileWriterService fileWriter = new FileWriterServiceImpl();
        fileWriter.write(balanceReport, STATISTIC_FILE_PATH);
    }
}
