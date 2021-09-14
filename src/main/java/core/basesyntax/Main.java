package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.FIleWriterService;
import core.basesyntax.service.FIleWriterServiceImpl;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileReaderServiceImpl;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.ParseServiceImpl;
import core.basesyntax.service.ReportMakerService;
import core.basesyntax.service.ReportMakerServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/fruits.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/report.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> rowsFromFile = fileReaderService.readRowsFromFile(INPUT_FILE_NAME);

        ParseService parseService = new ParseServiceImpl();
        for (int i = 1; i < rowsFromFile.size(); i++) {
            FruitRecord record = parseService.getParsedLine(rowsFromFile.get(i));
            char symbol = record.getOperation()
                    .name()
                    .toLowerCase()
                    .charAt(0);
            OperationHandler handler = Storage.getHandlerMap()
                    .get(ParseServiceImpl.getOperationByFirstLetter(symbol));
            handler.getChangedAmount(record);
        }

        ReportMakerService fruitReporter = new ReportMakerServiceImpl();
        String report = fruitReporter.getReport();

        FIleWriterService fileWriter = new FIleWriterServiceImpl();
        fileWriter.writeToFile(report, OUTPUT_FILE_NAME);
    }
}
