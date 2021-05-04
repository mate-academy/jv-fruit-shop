package core.basesyntax;

import core.basesyntax.model.OperationType;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitRecordDtoParser;
import core.basesyntax.service.Operation;
import core.basesyntax.service.Reader;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.AddOperation;
import core.basesyntax.service.impl.FruitRecordDtoParserImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.RemoveOperation;
import core.basesyntax.service.impl.WriterImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<String> dataFromFile = readFile();
        List<FruitRecordDto> recordDtos = parseData(dataFromFile);
        createReport(recordDtos);
        writeReport();
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

    private static void writeReport() {
        Writer reportWriter = new WriterImpl();
        reportWriter.writer("src/main/resources/report.csv");
    }

    private static List<String> readFile() {
        Reader reader = new ReaderImpl();
        List<String> rowsFromFile = reader.readFromFile("src/main/resources/shop_operations.csv");
        return rowsFromFile;
    }

    private static List<FruitRecordDto> parseData(List<String> rows) {
        FruitRecordDtoParser parser = new FruitRecordDtoParserImpl();
        List<FruitRecordDto> dtos = parser.parse(rows);
        return dtos;
    }

    private static void createReport(List<FruitRecordDto> recordDtos) {
        Map<OperationType, Operation> handlersOperation = getHandlersOperation();
        for (FruitRecordDto dto : recordDtos) {
            handlersOperation.get(dto.getOperationType()).apply(dto);
        }
    }
}
