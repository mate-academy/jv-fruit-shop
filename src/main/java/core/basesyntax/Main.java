package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionExecutor;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.TransactionExecutorImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import java.io.File;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        File inputFile = new File("src/main/resources/inputData.csv");
        FileReader fileReader = new FileReaderImpl();
        List<String> dataFromInputFile = fileReader.readFile(inputFile);
        TransactionParser transactionParser = new TransactionParserImpl();
        List<FruitTransaction> fruitTransactions = transactionParser.parse(dataFromInputFile);
        TransactionExecutor fruitProcessing = new TransactionExecutorImpl();
        Map<String, Integer> fruits = fruitProcessing.executeAll(fruitTransactions);
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.generateReport(fruits);
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(report);
    }
}
