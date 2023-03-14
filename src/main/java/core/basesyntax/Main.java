package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.*;
import core.basesyntax.service.impl.*;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        CsvFileReader readerService = new CsvFileReaderImpl();
        TransactionParseService transactionParserService = new TransactionParseServiceImpl();
        FruitShopService fruitShopService = new FruitShopServiceImpl(
                new OperationStrategyImpl(operationHandlerMap)
        );
        ReportCreatorService reportMakerService = new ReportCreatorServiceImpl();
        CsvFileWriterService writerService = new CsvFileWriterServiceImpl();
        List<FruitTransaction> parsed =
                transactionParserService.parse(readerService.readFromFile(INPUT_FILE));
        Map<String, Integer> preparedMap = fruitShopService.process(parsed);
        String preparedReport = reportMakerService.createReport(preparedMap);
        writerService.writeToFile(preparedReport, OUTPUT_FILE);
    }
}
