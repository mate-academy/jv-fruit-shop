package main;

import dao.FruitShopDao;
import dao.FruitShopDaoImpl;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.FruitShopService;
import service.FruitShopServiceImpl;
import strategy.BalanceStrategyImpl;
import strategy.OperationStrategy;

public class Main {
    private static final int ANNOTATION_SIZE = 1;
    private static final String STATISTIC_FILE_PATH = "src/main/resources/"
            + "balance.csv";
    private static final String DATA_FILE_PATH = "src/main/resources/dataBase.csv";

    public static void main(String[] args) {
        FruitShopService fruitShopService = new FruitShopServiceImpl();
        List<String> contentFromFile = fruitShopService.fileReader(DATA_FILE_PATH);
        List<FruitTransaction> fruitTransactions = contentFromFile.stream()
                .skip(ANNOTATION_SIZE)
                .map(fruitShopService::parseStringToTransaction)
                .collect(Collectors.toList());
        FruitShopDao dao = new FruitShopDaoImpl();
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            dao.add(fruitTransaction);
        }
        OperationStrategy strategy = new BalanceStrategyImpl();
        List<FruitTransaction> getAllFruitTransaction = dao.getAll();
        for (FruitTransaction fruitTransaction : getAllFruitTransaction) {
            strategy.executeStrategy(fruitTransaction);
        }
        Map<String, Integer> fruitStatistic = strategy.getFruitStatistic();
        List<String> balanceReport = fruitShopService.parseStatisticToString(fruitStatistic);
        fruitShopService.fileWriter(balanceReport, STATISTIC_FILE_PATH);
    }
}
