package myFruitShop;

import myFruitShop.Service.ReadInfo;
import myFruitShop.Service.ReadInfoImpl1;
import myFruitShop.Parser.DtoCreator;
import myFruitShop.Parser.FruitRecordToDto2;
import myFruitShop.Service.FruitShopService;
import myFruitShop.Service.FruitShopServiceImpl;
import myFruitShop.Service.OperationStrategy;
import myFruitShop.Service.OperationStrategyImpl;
import myFruitShop.Service.Operations.BalanceOperationHandler;
import myFruitShop.Service.Operations.OperationHandler;
import myFruitShop.Service.Operations.PurchaseOperationHandler;
import myFruitShop.Service.Operations.ReturnOperationHandler;
import myFruitShop.Service.Operations.SupplyOperationHandler;
import myFruitShop.ValidationProces.InvalidDataException;
import myFruitShop.ValidationProces.Validator;
import myFruitShop.ValidationProces.ValidatorImpl;
import myFruitShop.model.OperationType;
import myFruitShop.model.OperationsDto;

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


        ReadInfo operationReader = new ReadInfoImpl1();
        List<String> rawDataFromFile = operationReader.readFromFile("src/main/java/myFruitShop/InputDataForFruitShop");

        Validator inputDataValidator = new ValidatorImpl();
        List<String> validFruitShopData;
        try {
            validFruitShopData = inputDataValidator.validator(rawDataFromFile);        // what should i do with this exception
        } catch (InvalidDataException e) {
            throw new RuntimeException("Invalid input data", e);
        }
        DtoCreator dataParser = new FruitRecordToDto2();
        List<OperationsDto> operationsDataInDto = dataParser.toDtoDataFormatter(validFruitShopData);       // dto data

        OperationStrategy storageModifier = new OperationStrategyImpl(operationHandlerMap);
        FruitShopService operationsApplier = new FruitShopServiceImpl(storageModifier);
        operationsApplier.fruitStorageModifier(operationsDataInDto);                                      // do some staff with storage;
        operationsApplier.fileReportBuilder("ReportForFruitShop");
    }
}
