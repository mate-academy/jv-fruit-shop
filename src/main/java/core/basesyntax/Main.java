package core.basesyntax;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ResultGeneratorService;
import core.basesyntax.service.Validator;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ResultGeneratorServiceImpl;
import core.basesyntax.service.impl.ValidatorImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationsHandler;
import core.basesyntax.strategy.SelectOperation;
import jdk.dynalink.Operation;

import java.util.List;

public class Main {
    private static final String INPUT_PATH = "src/main/resources/inputData.csv";
    private static final String OUTPUT_PATH = "src/main/resources/outputData.csv";
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> read = readerService.read(INPUT_PATH);
        new ValidatorImpl().validate(read);
        for (String line: read) {
            String[] splittedLine = line.split(",");
            OperationsHandler operationsHandler
                    = SelectOperation.getOperation(line);
            operationsHandler.handleOperation(splittedLine[INDEX_OF_FRUIT],
                   Integer.parseInt(splittedLine[INDEX_OF_QUANTITY]));
        }
        ResultGeneratorService resultGeneratorService = new ResultGeneratorServiceImpl();
        String result = resultGeneratorService.generateResult(read);
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(OUTPUT_PATH, result);
    }
}
