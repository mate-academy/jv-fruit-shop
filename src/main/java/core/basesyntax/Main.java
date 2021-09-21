package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.implementation.FileReaderServiceImpl;
import core.basesyntax.service.FruitRecordDtoParser;
import core.basesyntax.service.implementation.FruitRecordDtoParserImpl;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.implementation.FruitShopServiceImpl;
import core.basesyntax.service.FruitRecordDtoCreator;
import core.basesyntax.service.implementation.FruitRecordDtoCreatorImpl;
import core.basesyntax.service.ReportMakerService;
import core.basesyntax.service.implementation.ReportMakerServiceImpl;
import core.basesyntax.service.ReportWriterService;
import core.basesyntax.service.implementation.ReportWriterServiceImpl;
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
        Map<FruitRecordDto.Type, OperationHandler> operationTypesMap = new HashMap<>();
        operationTypesMap.put(FruitRecordDto.Type.BALANCE, new BalanceOperationHandler());
        operationTypesMap.put(FruitRecordDto.Type.PURCHASE, new PurchaseOperationHandler());
        operationTypesMap.put(FruitRecordDto.Type.SUPPLY, new SupplyOperationHandler());
        operationTypesMap.put(FruitRecordDto.Type.RETURN, new ReturnOperationHandler());
        FruitDao fruitDao = new FruitDaoImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationTypesMap);
        FruitShopService fruitShop = new FruitShopServiceImpl(fruitDao, operationStrategy);
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        RecordValidator recordValidator = new RecordValidatorImpl();
        FruitRecordDtoParser fruitRecordDtoParser = new FruitRecordDtoParserImpl();
        FruitRecordDtoCreator fruitRecordDtoCreator = new FruitRecordDtoCreatorImpl(fileReaderService,
                recordValidator, fruitRecordDtoParser);
        fruitShop.updateStorage(FROM_FILE_NAME, fruitRecordDtoCreator);
        ReportMakerService reportMakerService = new ReportMakerServiceImpl();
        ReportWriterService reportWriterService = new ReportWriterServiceImpl(fruitDao,
                reportMakerService);
        reportWriterService.createReport(TO_FILE_NAME);
    }
}
