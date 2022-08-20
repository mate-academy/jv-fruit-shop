package core.basesyntax;

import static java.io.File.separator;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.AddOperationHandler;
import core.basesyntax.service.CsvReportCreatorImpl;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileReaderImpl;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FileWriterImpl;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ParsingService;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.SubtractOperationHandler;
import core.basesyntax.service.TransactionParsingServiceImpl;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.TransactionServiceImpl;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String PATH_INPUT_FILE = "src"
            + separator + "main"
            + separator + "resources"
            + separator + "InputFile.csv";
    private static final String PATH_REPORT_FILE = "src"
            + separator + "main"
            + separator + "resources"
            + separator + "ReportFile.csv";
    private static Map<FruitTransaction.Operation, OperationHandler> handlerMap = new HashMap<>();

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        final FileReader fileReader = new FileReaderImpl();
        handlerMap.put(FruitTransaction.Operation.BALANCE, new AddOperationHandler(fruitDao));
        handlerMap.put(FruitTransaction.Operation.SUPPLY, new AddOperationHandler(fruitDao));
        handlerMap.put(FruitTransaction.Operation.PURCHASE, new SubtractOperationHandler(fruitDao));
        handlerMap.put(FruitTransaction.Operation.RETURN, new AddOperationHandler(fruitDao));
        ParsingService parsingService = new TransactionParsingServiceImpl();
        TransactionService transactionService =
                new TransactionServiceImpl(new OperationStrategyImpl(handlerMap));
        transactionService.process(parsingService.parse(fileReader.readFromFile(PATH_INPUT_FILE)));
        ReportCreator reportCreator = new CsvReportCreatorImpl(fruitDao);
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(PATH_REPORT_FILE, reportCreator.create());
    }
}
