package core.basesyntax;

import core.basesyntax.dto.Transaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileReaderImpl;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FileWriterImpl;
import core.basesyntax.service.FruitOutputService;
import core.basesyntax.service.OutputService;
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
    private static final String INPUT_FILE_NAME = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(Operation.P, new PurchaseOperationHandler());
        handlers.put(Operation.S, new AddOperationHandler());
        handlers.put(Operation.B, new BalanceOperationHandler());
        handlers.put(Operation.R, new AddOperationHandler());
        FileReader fileReader = new FileReaderImpl();
        List<String> linesFromFile = fileReader.readFromFile(INPUT_FILE_NAME);
        List<Transaction> transactions = new ArrayList<>();
        Parser parser = new ParserImpl();
        for (int i = 1; i < linesFromFile.size(); i++) {
            Transaction transaction = parser.parseLine(linesFromFile.get(i).toUpperCase());
            OperationHandler handler = handlers.get(transaction.getOperation());
            handler.apply(transaction);
        }
        OutputService fruitReporter = new FruitOutputService();
        String report = fruitReporter.makeOutputResult();
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(report, OUTPUT_FILE_NAME);
    }
}
