package core.basesyntax;

import static core.basesyntax.model.FruitTransaction.FruitOperation.BALANCE;
import static core.basesyntax.model.FruitTransaction.FruitOperation.PURCHASE;
import static core.basesyntax.model.FruitTransaction.FruitOperation.RETURN;
import static core.basesyntax.model.FruitTransaction.FruitOperation.SUPPLY;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.OperationValidator;
import core.basesyntax.service.ReportCreator;
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

    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(BALANCE.getFirstLetter(), new BalanceHandlerImpl());
        operationHandlerMap.put(PURCHASE.getFirstLetter(), new PurchaseHandlerImpl());
        operationHandlerMap.put(RETURN.getFirstLetter(), new ReturnHandlerImpl());
        operationHandlerMap.put(SUPPLY.getFirstLetter(), new SupplyHandlerImpl());
        FileReader fileReader = new FileReaderImpl();
        String readFrom = "src/main/resources/input.csv";
        String writeTo = "src/main/resources/output.csv";
        OperationValidator validator = new OperationValidatorImpl();
        List<String> data = fileReader.readFromFile(readFrom);
        FruitTransactionParser transitionParser = new TransitionParserImpl(validator);
        List<FruitTransaction> fruitTransitionList
                = transitionParser.parse(data.toString());
        FruitTransactionService transitionService
                = new TransitionServiceImpl(new OperationHandlerStrategyImpl(operationHandlerMap));
        transitionService.process(fruitTransitionList);
        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.createReport(FruitStorage.storage);
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(report, writeTo);
    }
}
