package core.basesyntax;

import static core.basesyntax.model.FruitOperation.BALANCE;
import static core.basesyntax.model.FruitOperation.PURCHASE;
import static core.basesyntax.model.FruitOperation.RETURN;
import static core.basesyntax.model.FruitOperation.SUPPLY;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransition;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.OperationValidator;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.TransitionParser;
import core.basesyntax.service.TransitionService;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.OperationValidatorImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.TransitionParserImpl;
import core.basesyntax.service.impl.TransitionServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceHandlerImpl;
import core.basesyntax.strategy.impl.OperationHandlerStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseHandlerImpl;
import core.basesyntax.strategy.impl.ReturnHandlerImpl;
import core.basesyntax.strategy.impl.SupplyHandlerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String READ_FROM = "src/main/resources/input.csv";
    private static final String WRITE_TO = "src/main/resources/output.csv";
    private static final OperationValidator validator = new OperationValidatorImpl();

    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(BALANCE.getOperation(), new BalanceHandlerImpl());
        operationHandlerMap.put(PURCHASE.getOperation(), new PurchaseHandlerImpl());
        operationHandlerMap.put(RETURN.getOperation(), new ReturnHandlerImpl());
        operationHandlerMap.put(SUPPLY.getOperation(), new SupplyHandlerImpl());
        FileReader fileReader = new FileReaderImpl();
        List<String> dataBaseFromFile = fileReader.readFromFile(READ_FROM);
        TransitionParser transitionParser = new TransitionParserImpl(validator);
        List<FruitTransition> fruitTransitionList
                = transitionParser.parseTransition(dataBaseFromFile);
        TransitionService transitionService
                = new TransitionServiceImpl(new OperationHandlerStrategyImpl(operationHandlerMap));
        transitionService.doTransition(fruitTransitionList);
        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.createReport(FruitStorage.storage);
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeDataToFile(report, WRITE_TO);
    }
}
