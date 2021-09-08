package core.basesyntax;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.*;
import core.basesyntax.strategy.BalanceOperationHandlerImpl;
import core.basesyntax.strategy.DecreaseAmountOperationHandlerImpl;
import core.basesyntax.strategy.IncreaseAmountOperationHandlerImpl;
import core.basesyntax.strategy.OperationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    private static final String INPUT_FILE_NAME = "src/main/fruits.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/report.csv";

    public static void main(String[] args) {
        Map<FruitRecord.Operation, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(FruitRecord.Operation.PURCHASE, new DecreaseAmountOperationHandlerImpl());
        handlerMap.put(FruitRecord.Operation.SUPPLY, new IncreaseAmountOperationHandlerImpl());
        handlerMap.put(FruitRecord.Operation.BALANCE, new BalanceOperationHandlerImpl());
        handlerMap.put(FruitRecord.Operation.RETURN, new IncreaseAmountOperationHandlerImpl());

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> rowsFromFile = fileReaderService.readRowsFromFile(INPUT_FILE_NAME);

        ParseService parseService = new ParseServiceImpl();
        for (int i = 1; i < rowsFromFile.size(); i++) {
            FruitRecord record = parseService.getParsedLine(rowsFromFile.get(i));
            char symbol = record.getOperation().name().toLowerCase().charAt(0);
            OperationHandler handler = handlerMap.get(FruitRecord.getOperationByFirstLetter(symbol));
            handler.getChangedAmount(record);
        }

        ReportMakerService fruitReporter = new ReportMakerServiceImpl();
        String report = fruitReporter.getReport();

        FIleWriterService fileWriter = new FIleWriterServiceImpl();
        fileWriter.writeToFile(report, OUTPUT_FILE_NAME);
    }
}
