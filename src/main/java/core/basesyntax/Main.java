package core.basesyntax;

import core.basesyntax.model.FruitOperationDto;
import core.basesyntax.model.OperationType;
import core.basesyntax.operations.BalanceHandler;
import core.basesyntax.operations.ObtainingHandler;
import core.basesyntax.operations.OperationHandler;
import core.basesyntax.operations.OperationStrategy;
import core.basesyntax.operations.OperationStrategyImpl;
import core.basesyntax.operations.PurchaseHandler;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.fileservice.FileReader;
import core.basesyntax.service.fileservice.FileReaderImpl;
import core.basesyntax.service.fileservice.FileWriter;
import core.basesyntax.service.fileservice.FileWriterImpl;
import core.basesyntax.service.parser.Parser;
import core.basesyntax.service.parser.ParserImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/inputData.csv";
    private static final String OUTPUT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(OperationType.BALANCE.getShortOperation(),
                new BalanceHandler());
        operationHandlerMap.put(OperationType.PURCHASE.getShortOperation(),
                new PurchaseHandler());
        operationHandlerMap.put(OperationType.RETURN.getShortOperation(),
                new ObtainingHandler());
        operationHandlerMap.put(OperationType.SUPPLY.getShortOperation(),
                new ObtainingHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);
        FileReader readerService = new FileReaderImpl();
        List<String> data = readerService.read(INPUT_FILE);
        Parser<List<String>, List<FruitOperationDto>> parser = new ParserImpl();
        List<FruitOperationDto> fruitOperationDtoList = parser.parse(data);
        fruitShopService.saveToStorage(fruitOperationDtoList);
        FileWriter writerService = new FileWriterImpl();
        writerService.write(fruitShopService.createReport(), OUTPUT_FILE);
    }
}
