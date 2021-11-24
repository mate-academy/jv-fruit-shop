package core.basesyntax;

import core.basesyntax.io.MyReader;
import core.basesyntax.io.MyWriter;
import core.basesyntax.io.ioimpl.MyFileReader;
import core.basesyntax.io.ioimpl.MyFileWriter;
import core.basesyntax.model.OperationHandler;
import core.basesyntax.model.Record;
import core.basesyntax.model.strategy.BalanceHandler;
import core.basesyntax.model.strategy.PurchaseHandler;
import core.basesyntax.model.strategy.ReturnHandler;
import core.basesyntax.model.strategy.SupplyHandler;
import core.basesyntax.service.RecordParser;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.serviceimpl.RecordParserImpl;
import core.basesyntax.service.serviceimpl.ReportGeneratorImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, OperationHandler> handlers = new HashMap<>();
        handlers.put("b", new BalanceHandler());
        handlers.put("p", new PurchaseHandler());
        handlers.put("r", new ReturnHandler());
        handlers.put("s", new SupplyHandler());

        String inputFilePath = "src/main/resources/input.csv";
        MyReader reader = new MyFileReader();
        List<String> input = reader.read(inputFilePath);
        RecordParser parser = new RecordParserImpl();
        List<Record> records = parser.parseRecords(input);
        for (Record record : records) {
            OperationHandler handler = handlers.get(record.getTransactionAbbr());
            if (handler == null) {
                throw new RuntimeException("Unsupported operation type: "
                        + record.getTransactionAbbr());
            }
            handler.apply(record.getFruitName(), record.getAmount());
        }
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        List<String> report = reportGenerator.generate();
        String outputFilePath = "src/main/resources/output.csv";
        MyWriter writer = new MyFileWriter();
        writer.write(outputFilePath, report);
    }
}
