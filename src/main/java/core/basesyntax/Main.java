package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileReaderServiceImpl;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.RecordParserService;
import core.basesyntax.service.RecordParserServiceImpl;
import core.basesyntax.service.ReportWriterService;
import core.basesyntax.service.ReportWriterServiceImpl;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationStrategy;
import core.basesyntax.service.operation.OperationStrategyImpl;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import core.basesyntax.service.validator.RecordValidator;
import core.basesyntax.service.validator.RecordValidatorImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String FROM_FILE_NAME = "src/main/resources/DayActivities.csv";
    private static final String TO_FILE_NAME = "src/main/resources/FruitsBalanceInfo.csv";

    public static void main(String[] args) {
        Map<FruitRecord.Type, OperationHandler> operationTypesMap = new HashMap<>();
        operationTypesMap.put(FruitRecord.Type.BALANCE, new BalanceOperationHandler());
        operationTypesMap.put(FruitRecord.Type.PURCHASE, new PurchaseOperationHandler());
        operationTypesMap.put(FruitRecord.Type.SUPPLY, new SupplyOperationHandler());
        operationTypesMap.put(FruitRecord.Type.RETURN, new ReturnOperationHandler());
        FruitDao fruitDao = new FruitDaoImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationTypesMap);
        FruitShopService fruitShop = new FruitShopServiceImpl(fruitDao, operationStrategy);
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        RecordValidator recordValidator = new RecordValidatorImpl();
        RecordParserService recordParserService = new RecordParserServiceImpl(fileReaderService,
                recordValidator);
        fruitShop.updateStorage(FROM_FILE_NAME, recordParserService);
        ReportWriterService reportWriterService = new ReportWriterServiceImpl(fruitDao);
        reportWriterService.createReport(TO_FILE_NAME);
    }
}
