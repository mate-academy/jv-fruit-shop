package core.basesyntax;

import core.basesyntax.data.FruitTransaction;
import core.basesyntax.data.Stock;
import core.basesyntax.io.CsvFileReader;
import core.basesyntax.io.CsvFileWriter;
import core.basesyntax.io.ReaderFromFile;
import core.basesyntax.io.WriterToFile;
import core.basesyntax.service.FruitMapper;
import core.basesyntax.service.FruitMapperImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.strategy.TransactionProcessor;
import core.basesyntax.strategy.TransactionProcessorImpl;
import java.util.List;

public class Main {
    private static final String PATH_TO_INPUT_FILE = "src/main/java/resources/file.csv";
    private static final String PATH_TO_OUTPUT_FILE = "src/main/java/resources/report.csv";

    public static void main(String[] args) {
        ReaderFromFile fileReader = new CsvFileReader();
        List<String> allLines = fileReader.readFile(PATH_TO_INPUT_FILE);
        FruitMapper fruitMapper = new FruitMapperImpl();
        List<FruitTransaction> fruitTransactions = fruitMapper.mapData(allLines);
        TransactionProcessor transactionProcessor = new TransactionProcessorImpl();
        transactionProcessor.process(fruitTransactions);
        ReportService reportService = new ReportService();
        Stock stock = new Stock();
        List<String> report = reportService.generateReport(stock.getData());
        WriterToFile writeToFile = new CsvFileWriter();
        writeToFile.writeFile(report, PATH_TO_OUTPUT_FILE);
    }
}
