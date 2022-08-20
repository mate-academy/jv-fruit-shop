package core.basesyntax;

import static java.io.File.separator;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.AddOperation;
import core.basesyntax.service.CsvReportCreationImpl;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileReaderImpl;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FileWriterImpl;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ParsingService;
import core.basesyntax.service.ReportCreation;
import core.basesyntax.service.SubtractOperation;
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
        FileReader fileReader = new FileReaderImpl();
        handlerMap.put(FruitTransaction.Operation.BALANCE, new AddOperation(fruitDao));
        handlerMap.put(FruitTransaction.Operation.SUPPLY, new AddOperation(fruitDao));
        handlerMap.put(FruitTransaction.Operation.PURCHASE, new SubtractOperation(fruitDao));
        handlerMap.put(FruitTransaction.Operation.RETURN, new AddOperation(fruitDao));
        ParsingService parsingService = new TransactionParsingServiceImpl();
        TransactionService transactionService =
                new TransactionServiceImpl(new OperationStrategyImpl(handlerMap));
        transactionService.process(parsingService.parse(fileReader.readFromFile(PATH_INPUT_FILE)));
        ReportCreation reportCreation = new CsvReportCreationImpl(fruitDao);
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(PATH_REPORT_FILE, reportCreation.create());
    }
}
