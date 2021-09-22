package fruitshop;

import fruitshop.model.OperationType;
import fruitshop.model.RecordDto;
import fruitshop.parser.DtoCreator;
import fruitshop.parser.DtoCreatorImpl;
import fruitshop.service.FruitShopService;
import fruitshop.service.FruitShopServiceImpl;
import fruitshop.service.InputDataReader;
import fruitshop.service.InputDataReaderImpl;
import fruitshop.service.OperationStrategy;
import fruitshop.service.OperationStrategyImpl;
import fruitshop.service.operations.BalanceOperationHandler;
import fruitshop.service.operations.OperationHandler;
import fruitshop.service.operations.PurchaseOperationHandler;
import fruitshop.service.operations.ReturnOperationHandler;
import fruitshop.service.operations.SupplyOperationHandler;
import fruitshop.service.reporthandlers.FileWriter;
import fruitshop.service.reporthandlers.FileWriterImpl;
import fruitshop.service.reporthandlers.ReportGenerator;
import fruitshop.service.reporthandlers.ReportGeneratorImpl;
import fruitshop.service.validators.OperationsValidator;
import fruitshop.service.validators.OperationsValidatorImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String REPORT_FILE_NAME = "ReportForFruitShop";
    private static final String INPUT_FILE_PATH = "src/main/java/fruitshop/InputDataForFruitShop";

    public static void main(String[] args) {
        Map<OperationType, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(OperationType.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(OperationType.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(OperationType.RETURN, new ReturnOperationHandler());
        operationHandlerMap.put(OperationType.SUPPLY, new SupplyOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        InputDataReader operationReader = new InputDataReaderImpl();
        List<String> rawDataFromFile = operationReader
                .readFromFile(INPUT_FILE_PATH);
        OperationsValidator inputDataValidator = new OperationsValidatorImpl();
        List<String> validFruitShopData = inputDataValidator.validator(rawDataFromFile);
        DtoCreator dataParser = new DtoCreatorImpl();
        List<RecordDto> operationsDataInDto = dataParser.toDtoDataFormatter(validFruitShopData);
        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);
        fruitShopService.fruitStorageModifier(operationsDataInDto);
        ReportGenerator stringReport = new ReportGeneratorImpl();
        String report = stringReport.generateReport();
        FileWriter fileReport = new FileWriterImpl();
        fileReport.writeToFile(report, REPORT_FILE_NAME);
    }
}
