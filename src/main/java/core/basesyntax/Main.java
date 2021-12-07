package core.basesyntax;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.OperatePerDay;
import core.basesyntax.service.impl.StorageService;
import core.basesyntax.service.impl.StorageServiceAddImpl;
import core.basesyntax.service.impl.StorageServicePurchaseImpl;
import core.basesyntax.service.impl.StorageServiceSupplyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        StorageService storageServiceSupply = new StorageServiceSupplyImpl(new FruitDaoImpl());
        StorageService storageServicePurchase = new StorageServicePurchaseImpl(new FruitDaoImpl());
        StorageService storageServiceAdd = new StorageServiceAddImpl(new FruitDaoImpl());

        Map<String, StorageService> operationStorageMap = new HashMap<>();
        operationStorageMap.put("b",storageServiceAdd);
        operationStorageMap.put("s",storageServiceSupply);
        operationStorageMap.put("p",storageServicePurchase);
        operationStorageMap.put("r",storageServiceSupply);

        CsvFileReaderService csvFileReaderService = new CsvFileReaderService();
        List<String> operationalDay = csvFileReaderService.dataReader("FruitOperateDay.csv");

        OperatePerDay operatePerDay = new OperatePerDay();
        operatePerDay.createOperations(operationalDay, operationStorageMap);

        new CsvFileWriterService("dayOperatedBalance");

    }
}
