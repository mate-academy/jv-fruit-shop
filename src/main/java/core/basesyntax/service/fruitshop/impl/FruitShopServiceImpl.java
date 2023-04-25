package core.basesyntax.service.fruitshop.impl;

import core.basesyntax.dao.csv.CsvDao;
import core.basesyntax.dao.storage.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.fruitshop.FruitShopService;
import core.basesyntax.utils.Operation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FruitShopServiceImpl implements FruitShopService {
    private static final String ALREADY_EXIST_EXCEPTION = "Already exist";
    private static final String NOT_ENOUGH_EXCEPTION = "There is not enough fruits!";
    private static final long SKIP_FIRST_ROW = 1L;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SPLIT_SYMBOL = ",";
    private static final String FIRST_ROW_IN_REPORT = "fruit,quantity";
    private static final int FIRST_ROW_INDEX = 0;
    private StorageDao storageDao;
    private CsvDao csvDao;

    @Override
    public List<FruitTransaction> readAllFromCsv() {
        return csvDao.readCsv()
            .stream()
            .skip(SKIP_FIRST_ROW)
            .map(this::mapToFruitTransaction)
            .collect(Collectors.toList());
    }

    @Override
    public void exportReport() {
        List<String> mappedReport = mapToExport(storageDao.getAll());
        csvDao.writeToCsv(mappedReport);
    }

    @Override
    public void balance(String fruit, int quantity) {
        if (storageDao.checkIfExist(fruit)) {
            throw new RuntimeException(ALREADY_EXIST_EXCEPTION);
        }
        storageDao.put(fruit, quantity);
    }

    @Override
    public void supply(String fruit, int quantity) {
        if (!storageDao.checkIfExist(fruit)) {
            storageDao.put(fruit, quantity);
            return;
        }
        int newQuantity = storageDao.getQuantityByKey(fruit) + quantity;
        storageDao.put(fruit, newQuantity);
    }

    @Override
    public void purchase(String fruit, int quantity) {
        if (!storageDao.isEnoughFruits(fruit, quantity)) {
            throw new RuntimeException(NOT_ENOUGH_EXCEPTION);
        }
        int newQuantity = storageDao.getQuantityByKey(fruit) - quantity;
        storageDao.put(fruit, newQuantity);
    }

    @Override
    public void returnFruits(String fruit, int quantity) {
        supply(fruit, quantity);
    }

    private FruitTransaction mapToFruitTransaction(String row) {
        String[] strings = row.split(SPLIT_SYMBOL);
        return FruitTransaction
            .builder()
            .operation(Operation.byCode(strings[OPERATION_INDEX]))
            .fruit(strings[FRUIT_INDEX])
            .quantity(Integer.parseInt(strings[QUANTITY_INDEX]))
            .build();
    }

    private List<String> mapToExport(Map<String, Integer> storageMap) {
        List<String> resultList = new ArrayList<>();
        resultList.add(FIRST_ROW_INDEX, FIRST_ROW_IN_REPORT);
        List<String> preparedStorageData = storageMap.entrySet()
                .stream()
                .map(s -> s.getKey() + SPLIT_SYMBOL + s.getValue())
                .collect(Collectors.toList());
        resultList.addAll(preparedStorageData);
        return resultList;
    }
}
