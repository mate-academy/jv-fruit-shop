package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.TransactionDto;
import service.MyParser;
import service.MyReader;
import service.MyWriter;
import service.impl.MyParserImpl;
import service.impl.MyReaderImpl;
import service.impl.MyWriterImpl;
import service.impl.ReportServiceImpl;
import service.impl.ValidatorImpl;
import strategy.AddOperationHandler;
import strategy.BalanceOperationHandler;
import strategy.OperationHandler;
import strategy.PurchaseOperationHandler;

public class Main {
    private static final String INPUT_PATH = "src/main/resources/inputFile.csv";
    private static final String OUTPUT_PATH = "src/main/resources/outputFile.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("s", new AddOperationHandler());
        operationHandlerMap.put("r", new AddOperationHandler());
        operationHandlerMap.put("b", new BalanceOperationHandler());
        operationHandlerMap.put("p", new PurchaseOperationHandler());
        MyReader reader = new MyReaderImpl();
        List<String> lines = reader.readFromFile(INPUT_PATH);

        MyParser<TransactionDto> myParser = new MyParserImpl(new ValidatorImpl());

        List<TransactionDto> transactionDto = myParser.parseLines(lines);

        for (TransactionDto transaction : transactionDto) {
            String operation = transaction.getOperation();
            OperationHandler handler = operationHandlerMap.get(operation);
            handler.apply(transaction);
        }

        List<String> report = new ReportServiceImpl().createReport();

        MyWriter myWriter = new MyWriterImpl();
        myWriter.writeToFile(report, OUTPUT_PATH);

    }
}
