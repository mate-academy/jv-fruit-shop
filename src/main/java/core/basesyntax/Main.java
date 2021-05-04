package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import shopdao.FruitDaoImpl;
import shopoperations.Balance;
import shopoperations.ListOfOperations;
import shopoperations.Purchase;
import shopoperations.Return;
import shopoperations.ShopBalanceOperation;
import shopoperations.Supply;
import shopservice.CsvReadServiceImpl;
import shopservice.CsvWriteServiceImpl;
import shopservice.ReportCompilerImpl;
import shopservice.StoreService;
import shopservice.StoreServiceImpl;
import shopstrategy.StrategyImpl;

public class Main {

    public static void main(String[] args) {
        Map<ListOfOperations, ShopBalanceOperation> operationMap = new HashMap<>();
        operationMap.put(ListOfOperations.B, new Balance());
        operationMap.put(ListOfOperations.S, new Supply());
        operationMap.put(ListOfOperations.P, new Purchase());
        operationMap.put(ListOfOperations.R, new Return());
        StoreService storeService
                = new StoreServiceImpl(new StrategyImpl(operationMap), new FruitDaoImpl());
        List<String> data = new CsvReadServiceImpl().readFromFile("src/main/file.csv");
        storeService.addToStorage(data);
        new CsvWriteServiceImpl().writeToFile(new ReportCompilerImpl(
                new FruitDaoImpl()).getReport(), "src/main/report.csv");
    }
}
