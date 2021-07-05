package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileReaderImpl;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FileWriterImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.FruitReportService;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ParserImpl;
import core.basesyntax.strategy.AddOperationHandler;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String TYPE = "type";
    private static final String INPUT_FILE_NAME = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/output.csv";
    private static final int OPERATION_INDEX = 0;

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.p, new PurchaseOperationHandler());
        operationHandlers.put(Operation.s, new AddOperationHandler());
        operationHandlers.put(Operation.b, new BalanceOperationHandler());
        operationHandlers.put(Operation.r, new AddOperationHandler());

        FileReader fileReader = new FileReaderImpl();
        List<String> linesFromFile = fileReader.readFromFile(INPUT_FILE_NAME);

        List<Transaction> transactions = new ArrayList<>();
        Parser parser = new ParserImpl();
        for (int i = 1; i < linesFromFile.size(); i++) {
            transactions.add(parser.parseLine(linesFromFile.get(i)));
            OperationHandler handler = operationHandlers.get(transactions.get(i-1).getOperation());
            handler.apply(transactions.get(i-1));
        }

        ReportService fruitReporter = new FruitReportService();
        String report = fruitReporter.makeReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(report, OUTPUT_FILE_NAME);
    }
}
