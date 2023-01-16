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
import core.basesyntax.service.impl.FruitTransactionParserImpl;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.OperationValidatorImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceHandler;
import core.basesyntax.strategy.impl.OperationHandlerStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseHandler;
import core.basesyntax.strategy.impl.ReturnHandler;
import core.basesyntax.strategy.impl.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(BALANCE.getFirstLetter(), new BalanceHandler());
        operationHandlerMap.put(PURCHASE.getFirstLetter(), new PurchaseHandler());
        operationHandlerMap.put(RETURN.getFirstLetter(), new ReturnHandler());
        operationHandlerMap.put(SUPPLY.getFirstLetter(), new SupplyHandler());
        FileReader fileReader = new FileReaderImpl();
        String readFrom = "src/main/resources/input.csv";
        String writeTo = "src/main/resources/output.csv";
        OperationValidator validator = new OperationValidatorImpl();
        List<String> data = fileReader.readFromFile(readFrom);
        FruitTransactionParser transitionParser = new FruitTransactionParserImpl(validator);
        List<FruitTransaction> fruitTransitions
                = transitionParser.parse(data.toString());
        FruitTransactionService transitionService
                = new FruitTransactionServiceImpl(
                        new OperationHandlerStrategyImpl(operationHandlerMap));
        transitionService.process(fruitTransitions);
        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.createReport(FruitStorage.storage);
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(report, writeTo);
    }
}
