package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitProcessing;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitProcessingImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> dataFromInputFile = fileReader.getDataFromInputFile("inputData.csv");
        TransactionParser transactionParser = new TransactionParserImpl();
        List<FruitTransaction> fruitTransactions = transactionParser.parsOf(dataFromInputFile);
        FruitProcessing fruitProcessing = new FruitProcessingImpl();
        Map<String, Integer> fruits = fruitProcessing.fruitProcessing(fruitTransactions);
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.generateReport(fruits);
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.sendResultData(report);
    }
}
