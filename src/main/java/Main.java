import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.StrategyService;
import core.basesyntax.service.file.Parse;
import core.basesyntax.service.file.ReaderService;
import core.basesyntax.service.file.ReportCreator;
import core.basesyntax.service.file.Validator;
import core.basesyntax.service.file.WriterService;
import core.basesyntax.service.file.impl.ParseCsv;
import core.basesyntax.service.file.impl.ReaderCsv;
import core.basesyntax.service.file.impl.ReportCreatorCsv;
import core.basesyntax.service.file.impl.ValidatorImpl;
import core.basesyntax.service.file.impl.WriterCsv;
import core.basesyntax.service.handler.WorkWithFruits;
import core.basesyntax.service.handler.impl.FruitBalance;
import core.basesyntax.service.handler.impl.FruitPurchase;
import core.basesyntax.service.handler.impl.FruitReturn;
import core.basesyntax.service.handler.impl.FruitSupply;
import core.basesyntax.service.impl.StorageServiceImpl;
import core.basesyntax.service.impl.StrategyServiceImpl;
import core.basesyntax.strategy.FruitWorkStrategy;
import core.basesyntax.strategy.FruitWorkStrategyImp;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String spr = File.separator;
        String pathPattern = "src" + spr + "main" + spr + "resources" + spr;
        String validDataPath = pathPattern + "validData.csv";

        FruitDao fruitDao = new FruitDaoImpl();
        Validator validator = new ValidatorImpl();
        StrategyService strategyService = new StrategyServiceImpl();
        WriterService writerService = new WriterCsv();
        ReaderService readerService = new ReaderCsv(validDataPath);
        ReportCreator reportCreator = new ReportCreatorCsv(fruitDao);
        Parse parse = new ParseCsv();
        Map<Operation, WorkWithFruits> fruitStrategyMap = new HashMap<>();

        fruitStrategyMap.put(Operation.BALANCE, new FruitBalance());
        fruitStrategyMap.put(Operation.SUPPLY, new FruitSupply());
        fruitStrategyMap.put(Operation.PURCHASE, new FruitPurchase());
        fruitStrategyMap.put(Operation.RETURN, new FruitReturn());

        FruitWorkStrategy fruitWork = new FruitWorkStrategyImp(fruitStrategyMap);

        StorageService storageService = new StorageServiceImpl(validDataPath, fruitWork,
                fruitDao, validator,
                strategyService, writerService,
                readerService, reportCreator, parse);
        storageService.workWithStorage();

    }
}
