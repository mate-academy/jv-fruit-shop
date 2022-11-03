package core.basesyntax;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ContentGenerator;
import core.basesyntax.service.FileCsvReader;
import core.basesyntax.service.FileCsvWriter;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.OperationValidator;
import core.basesyntax.service.impl.ContentGeneratorImpl;
import core.basesyntax.service.impl.FileCsvReaderImpl;
import core.basesyntax.service.impl.FileCsvWriterImpl;
import core.basesyntax.service.impl.FruitTransactionParserImpl;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.OperationValidatorImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandlerImpl;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandlerImpl;
import core.basesyntax.strategy.impl.ReturnOperationHandlerImpl;
import core.basesyntax.strategy.impl.SupplyOperationHandlerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String WRITE_FROM = "src/main/resources/input.csv";
    private static final String WRITE_TO = "src/main/resources/report.csv";
    private static final OperationValidator operationValidator = new OperationValidatorImpl();

    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitOperation.BALANCE.getOperation(),
                new BalanceOperationHandlerImpl());
        operationHandlerMap.put(FruitOperation.PURCHASE.getOperation(),
                new PurchaseOperationHandlerImpl());
        operationHandlerMap.put(FruitOperation.RETURN.getOperation(),
                new ReturnOperationHandlerImpl());
        operationHandlerMap.put(FruitOperation.SUPPLY.getOperation(),
                new SupplyOperationHandlerImpl());

        FileCsvReader fileCsvReader = new FileCsvReaderImpl();
        List<String> list = fileCsvReader.readFromFile(WRITE_FROM);

        FruitTransactionParser fruitTransactionParser =
                new FruitTransactionParserImpl(operationValidator);
        List<FruitTransaction> fruitTransactionList =
                fruitTransactionParser.parseFruitTransactions(list);

        FruitTransactionService fruitTransactionService =
                new FruitTransactionServiceImpl(new OperationStrategyImpl(operationHandlerMap));
        fruitTransactionService.addToStorage(fruitTransactionList);

        ContentGenerator contentGenerator = new ContentGeneratorImpl();
        String content = contentGenerator.generateContent(FruitStorage.fruitStorage);

        FileCsvWriter fileCsvWriter = new FileCsvWriterImpl();
        fileCsvWriter.writeToFile(content, WRITE_TO);
    }
}
