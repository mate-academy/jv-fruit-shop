package core.basesyntax;

import core.basesyntax.dao.Dao;
import core.basesyntax.dao.DaoImpl;
import core.basesyntax.io.MyReader;
import core.basesyntax.io.MyWriter;
import core.basesyntax.io.ioimpl.MyFileReader;
import core.basesyntax.io.ioimpl.MyFileWriter;
import core.basesyntax.model.Record;
import core.basesyntax.service.RecordParser;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.serviceimpl.RecordParserImpl;
import core.basesyntax.service.serviceimpl.ReportGeneratorImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceHandler;
import core.basesyntax.strategy.impl.PurchaseHandler;
import core.basesyntax.strategy.impl.ReturnHandler;
import core.basesyntax.strategy.impl.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Dao dao = new DaoImpl();
        Map<String, OperationHandler> handlers = new HashMap<>();
        handlers.put("b", new BalanceHandler(dao));
        handlers.put("p", new PurchaseHandler(dao));
        handlers.put("r", new ReturnHandler(dao));
        handlers.put("s", new SupplyHandler(dao));

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
        ReportGenerator reportGenerator = new ReportGeneratorImpl(dao);
        List<String> report = reportGenerator.generate();
        String outputFilePath = "src/main/resources/output.csv";
        MyWriter writer = new MyFileWriter();
        writer.write(outputFilePath, report);
    }
}
