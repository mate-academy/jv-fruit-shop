import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.StrategyService;
import core.basesyntax.service.file.Parser;
import core.basesyntax.service.file.ReaderService;
import core.basesyntax.service.file.ReportCreator;
import core.basesyntax.service.file.Validator;
import core.basesyntax.service.file.WriterService;
import core.basesyntax.service.file.impl.ParserCsv;
import core.basesyntax.service.file.impl.ReaderCsv;
import core.basesyntax.service.file.impl.ReportCreatorCsv;
import core.basesyntax.service.file.impl.ValidatorImpl;
import core.basesyntax.service.file.impl.WriterCsv;
import core.basesyntax.service.handler.OperationHandler;
import core.basesyntax.service.handler.impl.BalanceOperationHandler;
import core.basesyntax.service.handler.impl.PurchaseOperationHandler;
import core.basesyntax.service.handler.impl.ReturnOperationHandler;
import core.basesyntax.service.handler.impl.SupplyOperationHandler;
import core.basesyntax.service.impl.StorageServiceImpl;
import core.basesyntax.service.impl.StrategyServiceImpl;
import core.basesyntax.strategy.FruitWorkStrategy;
import core.basesyntax.strategy.FruitWorkStrategyImpl;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String SPR = File.separator;
    private static final String PATH_PATTERN = "src" + SPR + "main" + SPR + "resources" + SPR;
    private static final String VALID_DATA_PATH = PATH_PATTERN + "validData.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        Validator validator = new ValidatorImpl();
        StrategyService strategyService = new StrategyServiceImpl();
        WriterService writerService = new WriterCsv();
        ReaderService readerService = new ReaderCsv();
        ReportCreator reportCreator = new ReportCreatorCsv();
        Parser parser = new ParserCsv();
        Map<Operation, OperationHandler> fruitStrategyMap = new HashMap<>();

        fruitStrategyMap.put(Operation.BALANCE, new BalanceOperationHandler(fruitDao));
        fruitStrategyMap.put(Operation.SUPPLY, new SupplyOperationHandler(fruitDao));
        fruitStrategyMap.put(Operation.PURCHASE, new PurchaseOperationHandler(fruitDao));
        fruitStrategyMap.put(Operation.RETURN, new ReturnOperationHandler(fruitDao));

        FruitWorkStrategy fruitWork = new FruitWorkStrategyImpl(fruitStrategyMap);
        StorageService storageService = new StorageServiceImpl(VALID_DATA_PATH, fruitWork,
                fruitDao, validator,
                strategyService, writerService,
                readerService, reportCreator, parser);
        storageService.workWithStorage();
    }
}
