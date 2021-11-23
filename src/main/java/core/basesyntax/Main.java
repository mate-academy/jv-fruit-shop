package core.basesyntax;

import core.basesyntax.service.fruitservice.FruitService;
import core.basesyntax.service.fruitservice.FruitServiceImpl;
import core.basesyntax.service.parser.Parser;
import core.basesyntax.service.parser.ParserImpl;
import core.basesyntax.service.reader.MyReader;
import core.basesyntax.service.reader.MyReaderImpl;
import core.basesyntax.service.validator.Validator;
import core.basesyntax.service.validator.ValidatorImpl;
import core.basesyntax.service.writer.MyWriter;
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
    private static final String BALANCE_OPERATION = "b";
    private static final String PURCHASE_OPERATION = "p";
    private static final String RETURN_OPERATION = "r";
    private static final String SUPPLY_OPERATION = "s";

    public static void main(String[] args) {
        Map<String, OperationHandler> handlers = new HashMap<>();
        handlers.put(BALANCE_OPERATION, new BalanceOperation());
        handlers.put(PURCHASE_OPERATION, new PurchaseOperation());
        handlers.put(RETURN_OPERATION, new AddOperation());
        handlers.put(SUPPLY_OPERATION, new AddOperation());

        Validator validator = new ValidatorImpl();
        Parser parser = new ParserImpl(validator);
        MyReader myReader = new MyReaderImpl();
        List<String> myList = myReader.readFromFile(INPUT_FILE_DESTINATION);
        myList.stream()
                .skip(1)
                .map(parser::parseLine)
                .forEach(o -> handlers.get(o.getOperation()).apply(o));
        FruitService fruitService = new FruitServiceImpl();
        String report = fruitService.getReport();
        MyWriter myWriter = new MyWriterImpl();
        myWriter.writeToFile(report, OUTPUT_FILE_DESTINATION);
    }
}
