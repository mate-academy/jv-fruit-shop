package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.dto.Transaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FruitReportService;
import core.basesyntax.service.Parser;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.strategy.AddOperationHandler;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String TYPE = "type";
    private static final String INPUT_FILE_NAME = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.P, new PurchaseOperationHandler());
        operationHandlers.put(Operation.S, new AddOperationHandler());
        operationHandlers.put(Operation.B, new BalanceOperationHandler());
        operationHandlers.put(Operation.R, new AddOperationHandler());

        FileReader fileReader = new FileReaderImpl();
        List<String> linesFromFile = fileReader.readFromFile(INPUT_FILE_NAME);

        Parser parser = new ParserImpl();
        for (int i = 1; i < linesFromFile.size(); i++) {
            Transaction transaction = parser.parseLine(linesFromFile.get(i));
            OperationHandler handler = operationHandlers.get(transaction.getOperation());
            handler.apply(transaction);
        }

        ReportService fruitReporter = new FruitReportService();
        String report = fruitReporter.makeReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(report, OUTPUT_FILE_NAME);
    }
}
