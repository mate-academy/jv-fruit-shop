package core.basesyntax;

import core.basesyntax.model.OperationType;
import core.basesyntax.service.fruitservice.FruitServiceImpl;
import core.basesyntax.service.parser.Parser;
import core.basesyntax.service.parser.ParserImpl;
import core.basesyntax.service.reader.MyReaderImpl;
import core.basesyntax.service.validator.ValidatorImpl;
import core.basesyntax.service.writer.MyWriterImpl;
import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.strategy.handlerimpls.AddOperation;
import core.basesyntax.strategy.handlerimpls.BalanceOperation;
import core.basesyntax.strategy.handlerimpls.PurchaseOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_DESTINATION = "src\\main\\resources\\inputFile.cvs";
    private static final String OUTPUT_FILE_DESTINATION = "src\\main\\resources\\outputFile.cvs";

    public static void main(String[] args) {
        Map<String, OperationHandler> handlers = new HashMap<>();
        handlers.put(OperationType.BALANCE.getType(), new BalanceOperation());
        handlers.put(OperationType.PURCHASE.getType(), new PurchaseOperation());
        handlers.put(OperationType.RETURN.getType(), new AddOperation());
        handlers.put(OperationType.SUPPLY.getType(), new AddOperation());

        Parser parser = new ParserImpl(new ValidatorImpl());
        List<String> myList = new MyReaderImpl().readFromFile(INPUT_FILE_DESTINATION);
        myList.stream()
                .skip(1)
                .map(parser::parseLine)
                .forEach(o -> handlers.get(o.getOperation()).apply(o));
        String report = new FruitServiceImpl().createReport();
        new MyWriterImpl().writeToFile(report, OUTPUT_FILE_DESTINATION);
    }
}
