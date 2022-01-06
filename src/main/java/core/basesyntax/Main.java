package core.basesyntax;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.ActivitiesService;
import core.basesyntax.service.ActivitiesServiceImpl;
import core.basesyntax.service.FileReaderFromFile;
import core.basesyntax.service.FileWriterToFile;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.activities.BalanceStorageServiceImpl;
import core.basesyntax.service.activities.PurchaseStorageServiceImpl;
import core.basesyntax.service.activities.ReturnStorageServiceImpl;
import core.basesyntax.service.activities.StorageService;
import core.basesyntax.service.activities.SupplyStorageServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        StorageService storageServiceBalance = new BalanceStorageServiceImpl(new FruitDaoImpl());
        StorageService storageServiceSupply = new SupplyStorageServiceImpl(new FruitDaoImpl());
        StorageService storageServicePurchase = new PurchaseStorageServiceImpl(new FruitDaoImpl());
        StorageService storageServiceReturn = new ReturnStorageServiceImpl(new FruitDaoImpl());

        Map<String, StorageService> storageServiceMap = new HashMap<>();
        storageServiceMap.put("b", storageServiceBalance);
        storageServiceMap.put("s", storageServiceSupply);
        storageServiceMap.put("p", storageServicePurchase);
        storageServiceMap.put("r", storageServiceReturn);

        FileReaderFromFile fileReaderFromCvs = new FileReaderFromFile();
        List<String> listFromFile = fileReaderFromCvs.readFromFile("operations.csv");

        ActivitiesService activitiesStrategy = new ActivitiesServiceImpl();
        activitiesStrategy.doingOperations(listFromFile, storageServiceMap);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();

        FileWriterToFile fileWriterToFile = new FileWriterToFile();
        fileWriterToFile.writeToFile("ReportOfFruits", report);

    }
}
