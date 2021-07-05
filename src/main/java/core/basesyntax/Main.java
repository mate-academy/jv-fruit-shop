package core.basesyntax;

import core.basesyntax.dto.Operations;
import core.basesyntax.dto.Transaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileReaderImpl;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FileWriterImpl;
import core.basesyntax.service.FruitReporter;
import core.basesyntax.service.FruitReporterImpl;
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
    private static final String INPUT_FILE_NAME = "src/main/java/core/basesyntax/input.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/java/core/basesyntax/output.csv";
    private static final int OPERATION_INDEX = 0;

    public static void main(String[] args) {
        Map<Operations, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Operations.p, new PurchaseOperationHandler());
        operationHandlers.put(Operations.s, new AddOperationHandler());
        operationHandlers.put(Operations.b, new BalanceOperationHandler());
        operationHandlers.put(Operations.r, new AddOperationHandler());

        FileReader fileReader = new FileReaderImpl();
        List<String> linesFromFile = fileReader.readFromFile(INPUT_FILE_NAME);

        List<Transaction> transactions = new ArrayList<>();
        Parser parser = new ParserImpl();
        for (String line : linesFromFile) {
            if (line.split(",")[OPERATION_INDEX].equals(TYPE)) {
                continue;
            }
            transactions.add(parser.parseLine(line));
        }
        for (Transaction transaction : transactions) {
            OperationHandler handler = operationHandlers.get(transaction.getOperation());
            handler.apply(transaction);
        }

        FruitReporter fruitReporter = new FruitReporterImpl();
        String report = fruitReporter.makeReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(report, OUTPUT_FILE_NAME);
    }
}
