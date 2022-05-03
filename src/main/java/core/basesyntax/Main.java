package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import operation.BalanceOperationHandler;
import operation.OperationHandler;
import operation.PurchaseOperationHandler;
import operation.ReturnOperationHandler;
import operation.SupplyOperationHandler;
import servise.converter.Converter;
import servise.converter.ConverterImpl;
import servise.reader.Reader;
import servise.reader.ReaderImpl;
import servise.reporter.Reporter;
import servise.reporter.ReporterImpl;
import servise.strategy.StrategyOperation;
import servise.strategy.StrategyOperationImpl;
import servise.writer.Writer;
import servise.writer.WriterImpl;

public class Main {
    private static final String PATH_INPUT_FILE = "src/main/resources/inputData.csv";
    private static final String PATH_REPORT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> map = new HashMap<>();
        map.put("b", new BalanceOperationHandler());
        map.put("s", new SupplyOperationHandler());
        map.put("r", new ReturnOperationHandler());
        map.put("p", new PurchaseOperationHandler());

        Reader readFromFile = new ReaderImpl();
        List<String> inputFromFile = readFromFile.readFromFile(PATH_INPUT_FILE);

        Converter convertToObject = new ConverterImpl();
        List<FruitTransaction> fruitTransactions = convertToObject.convert(inputFromFile);

        StrategyOperation strategyOperation = new StrategyOperationImpl(map);
        for (FruitTransaction fruits: fruitTransactions) {
            strategyOperation.getOperation(fruits).process(fruits);
        }

        Reporter reportService = new ReporterImpl();
        String reportString = reportService.createReport();

        Writer fileWriter = new WriterImpl();
        fileWriter.writeToFile(PATH_REPORT_FILE, reportString);
    }
}
