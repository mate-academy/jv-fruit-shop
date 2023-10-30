package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.WriterFile;
import core.basesyntax.strategy.CalculateStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WriterFileImplTest {
    String OUT_FILE_NAME = "src/main/resources/report.csv";

    @Test
    void isFinalResult_Ok() {
        FileReader fileReader = new FileReaderImpl();
        WriterFile fileWriter = new WriterFileImpl();
        //CalculateStrategy calculateStrategy = new CalculateStrategy(correspondenceTable);
        //TransactionProcessor transactionProcessor = new TransactionProcessorImpl(calculateStrategy);
        //TransactionParser transactionParser = new TransactionParserImpl();
        //ReportGenerator reportGenerator = new ReportGeneratorImpl();
        //List<String> strings = fileReader.readFile(INPUT_FILE_NAME);
        //List<FruitTransaction> listOfTransaction = transactionParser.parseTransaction(strings);
        //transactionProcessor.calculateBalance(listOfTransaction);
        fileWriter.writeToFile("Test message", OUT_FILE_NAME);
        List<String> strings = fileReader.readFile(OUT_FILE_NAME);
        assertEquals("[Test message]", strings.toString());
        assertThrows(RuntimeException.class, () -> fileReader.readFile("wrong file"));

    }
}