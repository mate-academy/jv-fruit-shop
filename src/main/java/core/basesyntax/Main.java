package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.OperationServiceImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.WriterImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceHandlerImpl;
import core.basesyntax.strategy.impl.PurchaseHandlerImpl;
import core.basesyntax.strategy.impl.ReturnHandlerImpl;
import core.basesyntax.strategy.impl.SupplyHandlerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new BalanceHandlerImpl());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseHandlerImpl());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyHandlerImpl());
        operationHandlerMap.put(Operation.RETURN, new ReturnHandlerImpl());

        Parser parseService = new ParserImpl();
        Reader fileReaderService = new ReaderImpl();
        List<String> input = fileReaderService
                .getDataFromFile("src/main/java/core/basesyntax/resources/fileInput.csv");
        List<Transaction> fruitTransactions = parseService.parse(input);

        OperationService operationService = new OperationServiceImpl(operationHandlerMap);
        FruitService fruitShopService = new FruitServiceImpl(operationService);
        fruitShopService.process(fruitTransactions);

        ReportCreator reportService = new ReportCreatorImpl();
        Writer fileWriterService = new WriterImpl();
        fileWriterService
                .writeDataToFile("src/main/java/core/basesyntax/resources/fileReport.csv",
                        reportService.createReport());
    }
}
