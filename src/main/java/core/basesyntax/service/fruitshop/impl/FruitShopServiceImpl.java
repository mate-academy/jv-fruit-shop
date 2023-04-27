package core.basesyntax.service.fruitshop.impl;

import core.basesyntax.dao.csv.CsvFileHandlerDao;
import core.basesyntax.dao.storage.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.fruitshop.FruitShopService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FruitShopServiceImpl implements FruitShopService {
    private static final String ALREADY_EXIST_EXCEPTION = "Already exist";
    private static final String NOT_ENOUGH_FRUITS_EXCEPTION = "There is not enough fruits!";
    private static final long SKIP_FIRST_ROW = 1L;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SPLIT_SYMBOL = ",";
    private static final String FIRST_ROW_IN_REPORT = "fruit,quantity";
    private static final int FIRST_ROW_INDEX = 0;
    private final String readFilePath;
    private final String writeFilePath;
    private final FruitStorageDao fruitStorageDao;
    private final CsvFileHandlerDao csvFileHandlerDao;

    @Override
    public List<FruitTransaction> readAllFromCsv() {
        return csvFileHandlerDao.readCsv(readFilePath)
            .stream()
            .skip(SKIP_FIRST_ROW)
            .map(this::mapToFruitTransaction)
            .collect(Collectors.toList());
    }

    @Override
    public void exportReport() {
        List<String> report = generateReport(fruitStorageDao.getAll());
        csvFileHandlerDao.writeToCsv(writeFilePath, report);
    }

    @Override
    public int balance(String fruit, int quantity) {
        if (fruitStorageDao.isFruitInStorage(fruit)) {
            throw new RuntimeException(ALREADY_EXIST_EXCEPTION);
        }
        return fruitStorageDao.addFruitQuantity(fruit, quantity);
    }

    @Override
    public int supply(String fruit, int quantity) {
        if (!fruitStorageDao.isFruitInStorage(fruit)) {
            return fruitStorageDao.addFruitQuantity(fruit, quantity);
        }
        return fruitStorageDao.merge(fruit, quantity, Integer::sum);
    }

    @Override
    public int purchase(String fruit, int quantity) {
        if (!fruitStorageDao.hasSufficientFruitQuantity(fruit, quantity)) {
            throw new RuntimeException(NOT_ENOUGH_FRUITS_EXCEPTION);
        }
        return fruitStorageDao.merge(fruit, quantity, (a, b) -> a - b);
    }

    @Override
    public int returnFruits(String fruit, int quantity) {
        return supply(fruit, quantity);
    }

    private FruitTransaction mapToFruitTransaction(String row) {
        String[] strings = row.split(SPLIT_SYMBOL);
        return FruitTransaction
            .builder()
            .operation(FruitTransaction.Operation.byCode(strings[OPERATION_INDEX]))
            .fruit(strings[FRUIT_INDEX])
            .quantity(Integer.parseInt(strings[QUANTITY_INDEX]))
            .build();
    }

    private List<String> generateReport(Map<String, Integer> storageMap) {
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
