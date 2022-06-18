package core.basesyntax;

import core.basesyntax.dao.ShopDao;
import core.basesyntax.dao.ShopDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.LineParserService;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.LineParserServiceImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.StrategyImpl;
import core.basesyntax.strategy.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH =
            "src/main/java/core/basesyntax/resources/fruit_shop_input_file.csv";
    private static final String REPORT_FILE_PATH =
            "src/main/java/core/basesyntax/resources/fruit_shop_report.csv";

    public static void main(String[] args) {
        ShopDao shopDao = new ShopDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandler = new HashMap<>();
        operationHandler.put(FruitTransaction.Operation.BALANCE, new BalanceHandler(shopDao));
        operationHandler.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler(shopDao));
        operationHandler.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler(shopDao));
        operationHandler.put(FruitTransaction.Operation.RETURN, new ReturnHandler(shopDao));

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> readFromFile = fileReaderService.readFromFile(INPUT_FILE_PATH);
        LineParserService fruitTParse = new LineParserServiceImpl();
        List<FruitTransaction> lineInfo = fruitTParse.lineInfo(readFromFile);
        Strategy strategy = new StrategyImpl(operationHandler);
        lineInfo.forEach(p -> strategy.get(p.getOperation()).handle(p));

        ReportCreatorService reportCreator = new ReportCreatorServiceImpl(shopDao);
        String report = reportCreator.report();

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.write(REPORT_FILE_PATH, report);
    }
}

