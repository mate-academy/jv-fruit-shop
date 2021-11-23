package core.basesyntax;

import model.TransactionDto;
import service.MyReader;
import service.MyWriter;
import service.MyParser;
import service.impl.*;
import strategy.AddOperationHandler;
import strategy.OperationHandler;
import strategy.PurchaseOperationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_PATH = "src/main/java/resources/inputFile.csv";
    private static final String OUTPUT_PATH = "src/main/java/resources/outputFile.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("s", new AddOperationHandler());
        operationHandlerMap.put("r", new AddOperationHandler());
        operationHandlerMap.put("b", new AddOperationHandler());
        operationHandlerMap.put("p", new PurchaseOperationHandler());
        MyReader reader = new MyReaderImpl();
        List<String> lines = reader.readFromFile(INPUT_PATH);

        MyParser<TransactionDto> myParser = new MyParserImpl(new ValidatorImpl());

        List<TransactionDto> transactionDto = myParser.parseLine(lines);

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
