package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FruitRecordDtoCreator;
import core.basesyntax.service.FruitRecordDtoParser;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReportMakerService;
import core.basesyntax.service.ReportWriterService;
import core.basesyntax.service.implementation.FileReaderServiceImpl;
import core.basesyntax.service.implementation.FruitRecordDtoCreatorImpl;
import core.basesyntax.service.implementation.FruitRecordDtoParserImpl;
import core.basesyntax.service.implementation.FruitShopServiceImpl;
import core.basesyntax.service.implementation.ReportMakerServiceImpl;
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
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FROM_FILE_NAME = "src/main/resources/DayActivities.csv";
    private static final String TO_FILE_NAME = "src/main/resources/FruitsBalanceInfo.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<FruitRecordDto.Type, OperationHandler> operationTypesMap = new HashMap<>();
        operationTypesMap.put(FruitRecordDto.Type.BALANCE, new BalanceOperationHandler(fruitDao));
        operationTypesMap.put(FruitRecordDto.Type.PURCHASE, new PurchaseOperationHandler(fruitDao));
        operationTypesMap.put(FruitRecordDto.Type.SUPPLY, new SupplyOperationHandler(fruitDao));
        operationTypesMap.put(FruitRecordDto.Type.RETURN, new ReturnOperationHandler(fruitDao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationTypesMap);
        FruitShopService fruitShop = new FruitShopServiceImpl(fruitDao, operationStrategy);
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> linesFromFile = fileReaderService.getRecords(FROM_FILE_NAME);
        RecordValidator recordValidator = new RecordValidatorImpl();
        FruitRecordDtoParser fruitRecordDtoParser = new FruitRecordDtoParserImpl(recordValidator);
        FruitRecordDtoCreator fruitRecordDtoCreator =
                new FruitRecordDtoCreatorImpl(fruitRecordDtoParser);
        List<FruitRecordDto> fruitRecordDtos = fruitRecordDtoCreator.createRecords(linesFromFile);
        fruitShop.updateStorage(fruitRecordDtos);
        ReportMakerService reportMakerService = new ReportMakerServiceImpl(fruitDao);
        List<String> stringsToWrite = reportMakerService.makeReport();
        ReportWriterService reportWriterService = new ReportWriterServiceImpl();
        reportWriterService.createReportFile(stringsToWrite, TO_FILE_NAME);
    }
}
