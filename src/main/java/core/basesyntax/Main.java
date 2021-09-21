package core.basesyntax;

import core.basesyntax.model.FruitOperationDto;
import core.basesyntax.model.TypeOperation;
import core.basesyntax.operations.BalanceOperation;
import core.basesyntax.operations.ObtainingOperation;
import core.basesyntax.operations.OperationHandler;
import core.basesyntax.operations.OperationStrategy;
import core.basesyntax.operations.OperationStrategyImpl;
import core.basesyntax.operations.PurchaseOperation;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReaderServiceImpl;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.WriterServiceImpl;
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
        operationHandlerMap.put(TypeOperation.BALANCE.getShortOperation(),
                new BalanceOperation());
        operationHandlerMap.put(TypeOperation.PURCHASE.getShortOperation(),
                new PurchaseOperation());
        operationHandlerMap.put(TypeOperation.RETURN.getShortOperation(),
                new ObtainingOperation());
        operationHandlerMap.put(TypeOperation.SUPPLY.getShortOperation(),
                new ObtainingOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);
        ReaderService readerService = new ReaderServiceImpl();
        List<String> data = readerService.read(INPUT_FILE);
        Parser<List<String>, List<FruitOperationDto>> parser = new ParserImpl();
        List<FruitOperationDto> fruitOperationDtoList = parser.parse(data);
        fruitShopService.saveToStorage(fruitOperationDtoList);
        WriterService writerService = new WriterServiceImpl();
        writerService.write(fruitShopService.createReport(), OUTPUT_FILE);
    }
}
