package core.basesyntax;

import core.basesyntax.model.OperationType;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitRecordDtoParser;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.Operation;
import core.basesyntax.service.Reader;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.AddOperation;
import core.basesyntax.service.impl.FruitRecordDtoParserImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.RemoveOperation;
import core.basesyntax.service.impl.WriterImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_PATH = "src/main/resources/shop_operations.csv";
    private static final String REPORT_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        List<String> dataFromFile = readFile();
        List<FruitRecordDto> recordDtos = parseData(dataFromFile);
        String report = createReport(recordDtos);
        Writer reportWriter = new WriterImpl();
        reportWriter.writer(report, REPORT_PATH);
    }

    private static Map<OperationType, Operation> getHandlersOperation() {
        Operation addOperation = new AddOperation();
        Operation removeOperation = new RemoveOperation();

        Map<OperationType, Operation> handlersOperation = new HashMap<>();
        handlersOperation.put(OperationType.BALANCE, addOperation);
        handlersOperation.put(OperationType.SUPPLY, addOperation);
        handlersOperation.put(OperationType.RETURN, addOperation);
        handlersOperation.put(OperationType.PURCHASE, removeOperation);

        return handlersOperation;
    }

    private static List<String> readFile() {
        Reader reader = new ReaderImpl();
        return reader.readFromFile(FILE_PATH);
    }

    private static List<FruitRecordDto> parseData(List<String> rows) {
        FruitRecordDtoParser parser = new FruitRecordDtoParserImpl();
        List<FruitRecordDto> dtos = parser.parse(rows);
        return dtos;
    }

    private static String createReport(List<FruitRecordDto> recordDtos) {
        FruitService fruitService = new FruitServiceImpl(getHandlersOperation());
        fruitService.saveData(recordDtos);
        return fruitService.getReport();
    }
}
