package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.TransactionDto;
import service.Parser;
import service.ParserImpl;
import service.Reader;
import service.ReaderImpl;
import service.ReportCreatorImpl;
import service.ValidatorImpl;
import service.Writer;
import service.WriterImpl;
import strategy.AddOperationHandler;
import strategy.BalanceOperationHandler;
import strategy.OperationHandler;
import strategy.PurchaseOperationHandler;

public class Main {
    private static final String DataBasePath = "src/database.csv";
    private static final String ReportFilePath = "src/report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("s", new AddOperationHandler());
        operationHandlerMap.put("p", new PurchaseOperationHandler());
        operationHandlerMap.put("r", new AddOperationHandler());
        operationHandlerMap.put("b", new BalanceOperationHandler());
        Reader reader = new ReaderImpl();
        List<String> lines = reader.readFromFile(DataBasePath);
        Parser<TransactionDto> parser = new ParserImpl(new ValidatorImpl());
        List<TransactionDto> transactionDto = parser.parseLine(lines);
        for (TransactionDto transaction : transactionDto) {
            String operation = transaction.getOperation();
            OperationHandler handler = operationHandlerMap.get(operation);
            handler.apply(transaction);
        }
        List<String> report = new ReportCreatorImpl().createReport();
        Writer writer = new WriterImpl();
        writer.writeToFile(report, ReportFilePath);
    }
}
