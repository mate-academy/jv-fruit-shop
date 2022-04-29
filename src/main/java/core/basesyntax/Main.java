package core.basesyntax;

import model.FruitTransaction;
import servise.converter.Converter;
import servise.converter.ConverterImp;
import servise.reader.Reader;
import servise.reader.ReaderImp;
import servise.report.Report;
import servise.report.ReportImp;
import servise.writer.Writer;
import servise.writer.WriterImp;
import strategy.BalanceOperationHandler;
import strategy.OperationHandler;
import strategy.PurchaseOperationHandler;
import strategy.ReturnOperationHandler;
import strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String path = "src\\main\\resources\\inputData.csv";
        String pathReport = "src\\main\\resources\\report.csv";

        Reader readFromFile = new ReaderImp();
        List<String> inputFromFile = readFromFile.readFromFile(path);

        Converter convertToObject = new ConverterImp();
        List<FruitTransaction> fruitTransactions = convertToObject.convert(inputFromFile);

        Map<String, OperationHandler> map = new HashMap<>();
        map.put("b", new BalanceOperationHandler());
        map.put("s", new SupplyOperationHandler());
        map.put("r", new ReturnOperationHandler());
        map.put("p", new PurchaseOperationHandler());

        for (FruitTransaction fruits: fruitTransactions) {
            OperationHandler handler = map.get(fruits.getOperation());
            handler.process(fruits);
        }

        Report report = new ReportImp();
        String reportString = report.report();

        Writer writeToFile = new WriterImp();
        writeToFile.writeToFile(pathReport, reportString);
    }
}
