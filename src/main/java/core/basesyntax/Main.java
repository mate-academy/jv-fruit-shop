package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.TransactionDto;
import service.Parser;
import service.Reader;
import service.Writer;
import service.impl.CsvReaderImpl;
import service.impl.ParserImpl;
import service.impl.ReportCreatorImpl;
import service.impl.ValidatorImpl;
import service.impl.WriterImpl;
import strategy.AddOperationHandler;
import strategy.BalanceOperationHandler;
import strategy.OperationHandler;
import strategy.PurchaseOperationHandler;

public class Main {
    private static final String DATABASE_PATH = "src/main/resources/database.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("s", new AddOperationHandler());
        operationHandlerMap.put("p", new PurchaseOperationHandler());
        operationHandlerMap.put("r", new AddOperationHandler());
        operationHandlerMap.put("b", new BalanceOperationHandler());
        Reader reader = new CsvReaderImpl();
        List<String> lines = reader.readFromFile(DATABASE_PATH);
        Parser<TransactionDto> parser = new ParserImpl(new ValidatorImpl());
        List<TransactionDto> transactionDto = parser.parseLines(lines);
        for (TransactionDto transaction : transactionDto) {
            String operation = transaction.getOperation();
            OperationHandler handler = operationHandlerMap.get(operation);
            handler.apply(transaction);
        }
        List<String> report = new ReportCreatorImpl().createReport();
        Writer writer = new WriterImpl();
        writer.writeToFile(report, REPORT_FILE_PATH);
    }
}
