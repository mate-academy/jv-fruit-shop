package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import servise.converter.Converter;
import servise.converter.ConverterImp;
import servise.reader.Reader;
import servise.reader.ReaderImp;
import servise.reporter.Reporter;
import servise.reporter.ReporterImp;
import servise.writer.Writer;
import servise.writer.WriterImp;
import strategy.BalanceOperationHandler;
import strategy.OperationHandler;
import strategy.PurchaseOperationHandler;
import strategy.ReturnOperationHandler;
import strategy.SupplyOperationHandler;

public class Main {
    private static final String PATH_INPUT_FILE = "src/main/resources/inputData.csv";
    private static final String PATH_REPORT_FILE = "src/main/resources/report.csv";
    private static OperationHandler handler;

    public static void main(String[] args) {
        Reader readFromFile = new ReaderImp();
        List<String> inputFromFile = readFromFile.readFromFile(PATH_INPUT_FILE);

        Converter convertToObject = new ConverterImp();
        final List<FruitTransaction> fruitTransactions = convertToObject.convert(inputFromFile);

        Map<String, OperationHandler> map = new HashMap<>();
        map.put("b", new BalanceOperationHandler());
        map.put("s", new SupplyOperationHandler());
        map.put("r", new ReturnOperationHandler());
        map.put("p", new PurchaseOperationHandler());

        for (FruitTransaction fruits: fruitTransactions) {
            handler = map.get(fruits.getOperation());
            handler.process(fruits);
        }

        Reporter report = new ReporterImp();
        String reportString = report.report();

        Writer writeToFile = new WriterImp();
        writeToFile.writeToFile(PATH_REPORT_FILE, reportString);
    }
}
