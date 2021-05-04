package core.basesyntax;

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

    private static Map<String, Operation> getHandlersOperation() {
        Operation addOperation = new AddOperation();
        Operation removeOperation = new RemoveOperation();

        Map<String, Operation> handlersOperation = new HashMap<>();
        handlersOperation.put("b", addOperation);
        handlersOperation.put("s", addOperation);
        handlersOperation.put("r", addOperation);
        handlersOperation.put("p", removeOperation);

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
        Map<String, Operation> handlersOperation = getHandlersOperation();
        for (FruitRecordDto dto : recordDtos) {
            handlersOperation.get(dto.getOperationType()).apply(dto);
        }
    }
}
