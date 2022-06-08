package core.basesyntax;

import core.basesyntax.service.DataValidator;
import core.basesyntax.service.FruitTransactionProcessor;
import core.basesyntax.service.MyFileReader;
import core.basesyntax.service.MyFileWriter;
import core.basesyntax.service.impl.DataValidatorImpl;
import core.basesyntax.service.impl.FruitTransactionProcessorImpl;
import core.basesyntax.service.impl.MyFileReaderImpl;
import core.basesyntax.service.impl.MyFileWriterImpl;
import core.basesyntax.strategy.FruitAdder;
import core.basesyntax.strategy.FruitHandler;
import core.basesyntax.strategy.FruitSubtractor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, FruitHandler> handlersMap = new HashMap<>();
        handlersMap.put("b", new FruitAdder());
        handlersMap.put("s", new FruitAdder());
        handlersMap.put("r", new FruitAdder());
        handlersMap.put("p", new FruitSubtractor());
        MyFileReader myFileReader = new MyFileReaderImpl();
        FruitTransactionProcessor fruitTransactionProcessor
                = new FruitTransactionProcessorImpl(handlersMap);
        MyFileWriter myFileWriter = new MyFileWriterImpl();
        DataValidator dataValidator = new DataValidatorImpl();

        List<String> info = myFileReader.readFromFile("src/main/resources/input.csv");
        dataValidator.validate(info);
        fruitTransactionProcessor.process(info);
        myFileWriter.writeToFile("src/main/resources/report.csv");
    }
}
