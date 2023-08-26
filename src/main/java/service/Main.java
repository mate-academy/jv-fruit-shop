package service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.dao.ParserImpl;
import service.dao.ParserTo;
import service.dao.ParserToImpl;
import service.dao.ReadFile;
import service.dao.ReadFileImpl;
import service.dao.WriteFile;
import service.dao.WriteFileImpl;
import service.storage.Balance;
import service.storage.PerformingOperation;
import service.storage.Purchase;
import service.storage.Return;
import service.storage.Supply;

public class Main {

    public static void main(String[] args) {
        final String balanceCode = "b";
        final String supplyCode = "s";
        final String purchaseCode = "p";
        final String returnCode = "r";
        // Read data from file
        String filePath = "src/main/resources/fileFrom.csv";
        File file = new File(filePath);
        List<String> listFromFile = new ArrayList<>();
        ReadFile fileDao = new ReadFileImpl();
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        // Convert data to Java object
        ParserImpl parser = new ParserImpl(fruitTransactions);
        fruitTransactions = parser
                .parsedToFruitTransaction(fileDao.readFromFileToList(file,listFromFile));
        // Data operation Strategy
        final Map<String,Integer> map = new HashMap<>();
        HashMap<String, PerformingOperation> operationHashMap = new HashMap<>();
        operationHashMap.put(balanceCode, new Balance());
        operationHashMap.put(purchaseCode, new Purchase());
        operationHashMap.put(returnCode, new Return());
        operationHashMap.put(supplyCode, new Supply());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHashMap);
        // Data processing
        ShopServiceImpl shopService = new ShopServiceImpl(operationStrategy);
        shopService.getRepport(fruitTransactions,map);
        // Create report
        ParserTo parserTo = new ParserToImpl();
        List<String> report = parserTo.parsedListToFile(map);
        // Write report to file
        String filePathTo = "src/main/resources/fileTo.csv";
        File fileTo = new File(filePathTo);
        WriteFile writeFile = new WriteFileImpl();
        writeFile.writeListToFile(report,fileTo);
    }
}
