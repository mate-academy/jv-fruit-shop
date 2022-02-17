package core.basesyntax;

import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.sevice.ConvertReadedDataServiceImpl;
import core.basesyntax.sevice.ConvertWriteDataService;
import core.basesyntax.sevice.ConvertWriteDataServiceImpl;
import core.basesyntax.sevice.FileReadServiceImpl;
import core.basesyntax.sevice.FileWriteService;
import core.basesyntax.sevice.FileWriteServiceImpl;
import core.basesyntax.sevice.FruitShopService;
import core.basesyntax.sevice.FruitShopServiceImpl;
import core.basesyntax.strategy.OperationProcess;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.impl.BalanceOperationProcess;
import core.basesyntax.strategy.impl.PurchaseOperationProcess;
import core.basesyntax.strategy.impl.ReturnOperationProcess;
import core.basesyntax.strategy.impl.SupplyOperationProcess;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitStorageMain {
    private static final String SOURCE_FILE_NAME = "src/main/resources/InputData.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/Report.csv";

    public static void main(String[] args) {
        List<String> dataFromFile = new FileReadServiceImpl().readDataFromFile(SOURCE_FILE_NAME);
        List<FruitTransaction> convertedData = new ConvertReadedDataServiceImpl()
                .convertDataFromFile(dataFromFile);
        FruitShopService fruitShopService
                = new FruitShopServiceImpl(new OperationStrategyImpl(createOperationProcessMap()));
        fruitShopService.fruitShopOperation(convertedData);
        ConvertWriteDataService convertWriteDataService = new ConvertWriteDataServiceImpl();
        String report
                = convertWriteDataService.convertDataToFile(new FruitStorageDaoImpl()
                        .getStorageState());
        FileWriteService fileWriteService = new FileWriteServiceImpl();
        fileWriteService.writeDataToFile(report, REPORT_FILE_NAME);
    }

    public static Map<FruitTransaction.Operation, OperationProcess> createOperationProcessMap() {
        Map<FruitTransaction.Operation, OperationProcess> operationProcessMap =
                new HashMap<>();
        operationProcessMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationProcess());
        operationProcessMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationProcess());
        operationProcessMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationProcess());
        operationProcessMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationProcess());
        return operationProcessMap;
    }
}
