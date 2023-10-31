package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.service.DataHandlerService;
import core.basesyntax.service.OperationService;
import core.basesyntax.strategy.StorageUpdateStrategy;
import core.basesyntax.strategy.impl.FruitBalanceStrategy;
import core.basesyntax.strategy.impl.FruitPurchaseStrategy;
import core.basesyntax.strategy.impl.FruitReturnStrategy;
import core.basesyntax.strategy.impl.FruitSupplyStrategy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataHandlerServiceImpl implements DataHandlerService {
    private static final String REPORT_COLUMNS = "fruit,quantity";
    private static final int INDEX_OF_REPORT_COLUMNS = 1;
    private static final String SEPARATE_SYMBOL = ",";
    private final List<StorageUpdateStrategy> storageUpdateStrategies = createServicesList();
    private final OperationService operationService =
            new OperationServiceImpl(storageUpdateStrategies);
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public String calculateInputData(String inputData) {
        List<String> productTransactionsList = getOperationsList(inputData);
        for (String productTransaction : productTransactionsList) {
            addProductTransaction(productTransaction);
        }
        return getFinalReport();
    }

    private String getFinalReport() {
        StringBuilder reportBuilder = new StringBuilder(REPORT_COLUMNS);
        fruitDao.getAll().forEach((key, value) ->
                reportBuilder.append(System.lineSeparator())
                        .append(key.getProductName())
                        .append(SEPARATE_SYMBOL)
                        .append(value));
        return reportBuilder.toString();
    }

    private void addProductTransaction(String productTransaction) {
        String[] separatedTransaction = productTransaction.split(SEPARATE_SYMBOL);
        String operationCode = separatedTransaction[0];
        String productName = separatedTransaction[1];
        int productAmount = Integer.parseInt(separatedTransaction[2]);
        operationService.manageStorageCells(operationCode, productName, productAmount);
    }

    private List<String> getOperationsList(String inputData) {
        return Arrays.stream(inputData.split(System.lineSeparator()))
                .skip(INDEX_OF_REPORT_COLUMNS)
                .toList();
    }

    private List<StorageUpdateStrategy> createServicesList() {
        List<StorageUpdateStrategy> storageUpdateServices = new ArrayList<>();
        storageUpdateServices.add(new FruitBalanceStrategy());
        storageUpdateServices.add(new FruitSupplyStrategy());
        storageUpdateServices.add(new FruitPurchaseStrategy());
        storageUpdateServices.add(new FruitReturnStrategy());
        return storageUpdateServices;
    }
}
