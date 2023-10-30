package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.CalculateStrategy;
import core.basesyntax.strategy.OperationHandlerBalance;
import core.basesyntax.strategy.OperationHandlerIn;
import core.basesyntax.strategy.OperationHandlerOut;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TransactionProcessorImplTest {
    String INPUT_FILE_NAME = "src/main/resources/fruits.csv";
    Map<FruitTransaction.Operation, OperationHandler>
            correspondenceTable = Map.of(
            FruitTransaction.Operation.BALANCE, new OperationHandlerBalance(),
            FruitTransaction.Operation.SUPPLY, new OperationHandlerIn(),
            FruitTransaction.Operation.RETURN, new OperationHandlerIn(),
            FruitTransaction.Operation.PURCHASE, new OperationHandlerOut());

    @Test
    void calculateBalanceTest_Ok() {

        FileReader fileReader = new FileReaderImpl();
        CalculateStrategy calculateStrategy = new CalculateStrategy(correspondenceTable);
        TransactionProcessor transactionProcessor = new TransactionProcessorImpl(calculateStrategy);
        TransactionParser transactionParser = new TransactionParserImpl();
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        List<String> strings = fileReader.readFile(INPUT_FILE_NAME);
        List<FruitTransaction> listOfTransaction = transactionParser.parseTransaction(strings);

        int storageSize = Storage.storage.size();
        transactionProcessor.calculateBalance(listOfTransaction);
        assertNotEquals(storageSize, Storage.storage.size());
        assertEquals(152, Storage.storage.get("banana"));
        assertEquals(90, Storage.storage.get("apple"));

        /*
        FileReader fileReader = new FileReaderImpl();
        WriterFile fileWriter = new WriterFileImpl();
        CalculateStrategy calculateStrategy = new CalculateStrategy(correspondenceTable);
        TransactionProcessor transactionProcessor = new TransactionProcessorImpl(calculateStrategy);
        TransactionParser transactionParser = new TransactionParserImpl();
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        List<String> strings = fileReader.readFile(INPUT_FILE_NAME);
        List<FruitTransaction> listOfTransaction = transactionParser.parseTransaction(strings);
        transactionProcessor.calculateBalance(listOfTransaction);
        fileWriter.writeToFile(reportGenerator.makeReport(), OUT_FILE_NAME);


         */
    }
}