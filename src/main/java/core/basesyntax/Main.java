package core.basesyntax;

import core.basesyntax.data.FruitMapper;
import core.basesyntax.data.FruitMapperImpl;
import core.basesyntax.data.FruitTransaction;
import core.basesyntax.data.ReportService;
import core.basesyntax.data.Stock;
import core.basesyntax.io.CsvFileReader;
import core.basesyntax.io.CsvFileWriter;
import core.basesyntax.io.ReadFromFile;
import core.basesyntax.io.WriteToFile;
import core.basesyntax.strategy.OperationProcessor;
import core.basesyntax.strategy.OperationProcessorImpl;
import java.util.List;

public class Main {
    private static final String PATH_TO_INPUT_FILE = "src/main/java/resources/file.csv";
    private static final String PATH_TO_OUTPUT_FILE = "src/main/java/resources/report.csv";

    public static void main(String[] args) {
        ReadFromFile fileReader = new CsvFileReader();
        List<String> allLines = fileReader.readFile(PATH_TO_INPUT_FILE);
        FruitMapper fruitMapper = new FruitMapperImpl();
        List<FruitTransaction> fruitTransactions = fruitMapper.mapData(allLines);
        OperationProcessor operationProcessor = new OperationProcessorImpl();
        Stock processReport = operationProcessor.process(fruitTransactions);
        ReportService reportService = new ReportService();
        List<String> report = reportService.generateReport(processReport.getData());
        WriteToFile writeToFile = new CsvFileWriter();
        writeToFile.writeFile(report, PATH_TO_OUTPUT_FILE);
    }
}
