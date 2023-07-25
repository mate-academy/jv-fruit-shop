package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.*;
import core.basesyntax.service.handler.*;
import core.basesyntax.service.impl.*;
import core.basesyntax.service.strategy.OperationStrategyImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_PATH_FILE = "src/main/java/core/basesyntax/resources/InputData.csv";
    private static final String OUTPUT_PATH_FILE = "src/main/java/core/basesyntax/resources/OutputData.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());

        ReaderFileService readerFileService = new ReaderFileServiceImpl();
        List<String> data = readerFileService.read(INPUT_PATH_FILE);

        ParseDataService parseDataService = new ParseDataServiceImpl();
        List<FruitTransaction> transactions = parseDataService.parseFile(data);

        FruitShopProcessService fruitShopProcessService
                = new FruitShopProcessServiceImp(new OperationStrategyImpl(operationHandlerMap));
        fruitShopProcessService.fruitShopProcess(transactions);

        GenerateReportService generateReportService = new GenerateReportServiceImpl();
        String report = generateReportService.generateReport();

        WriterFileService writerFileService = new WriterFileServiceImpl();
        writerFileService.write(OUTPUT_PATH_FILE, report);


    }
}

