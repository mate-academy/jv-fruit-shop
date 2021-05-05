package core.basesyntax;

import core.basesyntax.dto.Operation;
import core.basesyntax.exceptions.AlreadyHaveItException;
import core.basesyntax.exceptions.IllegalDataException;
import core.basesyntax.service.OperationParser;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.StorageService;
import core.basesyntax.strategy.OperationService;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_PATH = "src/operations_list.csv";
    private static final String OUTPUT_FILE_PATH = "src/report.csv";
    public static void main(String[] args) throws IOException, AlreadyHaveItException, IllegalDataException {
        DataReader dataReader = new DataReader();
        List<String> operationsList = dataReader.readData(INPUT_FILE_PATH);
        Parser dataParser = new OperationParser();
        List<Operation> allOperations = dataParser.parseOperationsToList(operationsList);
        StorageService storage = new StorageService();
        OperationService operationService = new OperationService(storage);
        operationService.applyOperations(allOperations);
        ReportService reportMaker = new ReportService();
        String report = reportMaker.buildReport(storage);
        reportMaker.writeData(OUTPUT_FILE_PATH, report);
    }
}
