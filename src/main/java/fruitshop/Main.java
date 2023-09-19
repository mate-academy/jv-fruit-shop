package fruitshop;

import fruitshop.model.FruitTransaction;
import fruitshop.model.Operation;
import fruitshop.service.FruitService;
import fruitshop.service.DataParser;
import fruitshop.service.FileReader;
import fruitshop.service.ReportCreator;
import fruitshop.service.FileWriter;
import fruitshop.service.serviceimpl.FileReaderImpl;
import fruitshop.service.serviceimpl.FileWriterImpl;
import fruitshop.service.serviceimpl.FruitServiceImpl;
import fruitshop.service.serviceimpl.DataParserImpl;
import fruitshop.service.serviceimpl.ReportCreatorImpl;
import fruitshop.strategy.operation.OperationHandler;
import fruitshop.strategy.operation.impl.BalanceOperationHandler;
import fruitshop.strategy.operation.impl.PurchaseOperationHandler;
import fruitshop.strategy.operation.impl.ReturnOperationHandler;
import fruitshop.strategy.operation.impl.SupplyOperationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String fromFile = "src/main/resources/fruitdata.csv";
    private static final String toFile = "src/main/resources/result.csv";

    public static void main(String[] args) {
        FileReader reader = new FileReaderImpl();
        DataParser parser = new DataParserImpl();
        List<String> fromFileData = reader.readDataFromFile(fromFile);
        List<FruitTransaction> fruitData = parser.parseStringToDataObject(fromFileData);
        Map<Operation, OperationHandler> operationHandlerMap = getOperationHandlerMap();
        FruitService fruitService = new FruitServiceImpl(fruitData, operationHandlerMap);
        fruitService.processFruits();
        ReportCreator reportInterface = new ReportCreatorImpl();
        String report = reportInterface.createReport();
        FileWriter writer = new FileWriterImpl();
        writer.writeDataToTheFile(toFile, report);
    }

    private static Map<Operation, OperationHandler> getOperationHandlerMap() {
        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(Operation.RETURN, new ReturnOperationHandler());
        return operationHandlerMap;
    }
}
