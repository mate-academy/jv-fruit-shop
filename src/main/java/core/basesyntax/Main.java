package core.basesyntax;

import static core.basesyntax.model.Operation.BALANCE;
import static core.basesyntax.model.Operation.PURCHASE;
import static core.basesyntax.model.Operation.RETURN;
import static core.basesyntax.model.Operation.SUPPLY;

import core.basesyntax.database.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.OperationValidation;
import core.basesyntax.service.ReportConstructor;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.OperationValidatorImpl;
import core.basesyntax.service.impl.ReportConstructorImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandleImpl;
import core.basesyntax.strategy.impl.OperationHandleStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandleImpl;
import core.basesyntax.strategy.impl.ReturnOperationHandleImpl;
import core.basesyntax.strategy.impl.SupplyOperationHandleImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FROM_FILE_PATH = "src/main/java/resources/input.csv";
    private static final String TO_FILE_PATH = "src/main/java/resources/output.csv";
    private static final OperationValidation validator = new OperationValidatorImpl();

    public static void main(String[] args) {
        Map<Operation, OperationHandler> handleMap = new HashMap<>();
        handleMap.put(BALANCE, new BalanceOperationHandleImpl());
        handleMap.put(SUPPLY, new SupplyOperationHandleImpl());
        handleMap.put(PURCHASE, new PurchaseOperationHandleImpl());
        handleMap.put(RETURN, new ReturnOperationHandleImpl());

        FileReader fileReader = new FileReaderImpl();
        List<String> list = fileReader.readFile(FROM_FILE_PATH);

        TransactionParser parser = new TransactionParserImpl(validator);
        List<FruitTransaction> transactions = parser.parseTransaction(list);

        TransactionService transactionService = new TransactionServiceImpl(
                new OperationHandleStrategyImpl(handleMap));
        transactionService.transferToStorage(transactions);

        ReportConstructor reportConstructor = new ReportConstructorImpl();
        String report = reportConstructor.createReport(FruitStorage.fruitStorage);

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(report, TO_FILE_PATH);
    }
}
