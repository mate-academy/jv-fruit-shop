package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.WriterFile;
import core.basesyntax.strategy.CalculateStrategy;
import core.basesyntax.strategy.OperationHandlerBalance;
import core.basesyntax.strategy.OperationHandlerIn;
import core.basesyntax.strategy.OperationHandlerOut;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ReportGeneratorImplTest {

    Map<FruitTransaction.Operation, OperationHandler>
            correspondenceTable = Map.of(
            FruitTransaction.Operation.BALANCE, new OperationHandlerBalance(),
            FruitTransaction.Operation.SUPPLY, new OperationHandlerIn(),
            FruitTransaction.Operation.RETURN, new OperationHandlerIn(),
            FruitTransaction.Operation.PURCHASE, new OperationHandlerOut());

    private static final String INPUT_FILE_NAME = "src/main/resources/fruits.csv";
    private static final String OUT_FILE_NAME = "src/main/resources/report.csv";
    FileReader fileReader = new FileReaderImpl();
    WriterFile fileWriter = new WriterFileImpl();
    CalculateStrategy calculateStrategy = new CalculateStrategy(correspondenceTable);
    TransactionProcessor transactionProcessor = new TransactionProcessorImpl(calculateStrategy);
    TransactionParser transactionParser = new TransactionParserImpl();
    ReportGenerator reportGenerator = new ReportGeneratorImpl();
    List<String> strings = fileReader.readFile(INPUT_FILE_NAME);
    List<FruitTransaction> listOfTransaction = transactionParser.parseTransaction(strings);



    @Test
    void makeReportIs_Ok() {

        transactionProcessor.calculateBalance(listOfTransaction);
        String report = reportGenerator.makeReport();
        assertEquals(report,"banana, 152"
                + System.lineSeparator()
                + "apple, 90"
                + System.lineSeparator());



    }
    @Test
    void makeReportIsNullNot_Ok() {
        transactionProcessor.calculateBalance(listOfTransaction);
        assertNotNull(reportGenerator.makeReport());
    }

}