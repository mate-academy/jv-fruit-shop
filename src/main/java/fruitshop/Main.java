package fruitshop;

import fruitshop.model.OperationType;
import fruitshop.model.OperationsDto;
import fruitshop.parser.DtoCreationImpl;
import fruitshop.parser.DtoCreator;
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
import fruitshop.service.validators.InvalidDataException;
import fruitshop.service.validators.OperationsValidator;
import fruitshop.service.validators.ValidatorImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<OperationType, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(OperationType.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(OperationType.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(OperationType.RETURN, new ReturnOperationHandler());
        operationHandlerMap.put(OperationType.SUPPLY, new SupplyOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        InputDataReader operationReader = new InputDataReaderImpl();
        List<String> rawDataFromFile = operationReader
                .readFromFile("src/main/java/fruitshop/InputDataForFruitShop");
        OperationsValidator inputDataValidator = new ValidatorImpl();
        List<String> validFruitShopData;
        try {
            validFruitShopData = inputDataValidator.validator(rawDataFromFile);
        } catch (InvalidDataException e) {
            throw new RuntimeException("Invalid input data", e);
        }
        DtoCreator dataParser = new DtoCreationImpl();
        List<OperationsDto> operationsDataInDto = dataParser.toDtoDataFormatter(validFruitShopData);
        OperationStrategy storageModifier = new OperationStrategyImpl(operationHandlerMap);
        FruitShopService operationsApplier = new FruitShopServiceImpl(storageModifier);
        operationsApplier.fruitStorageModifier(operationsDataInDto);
        operationsApplier.fileReportBuilder("ReportForFruitShop");
    }
}
