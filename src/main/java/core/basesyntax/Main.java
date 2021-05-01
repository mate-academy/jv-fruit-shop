package core.basesyntax;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.AddOperation;
import core.basesyntax.service.FileReaderImplForCsv;
import core.basesyntax.service.FruitAvailabilityValidatorImpl;
import core.basesyntax.service.FruitRecordDtoParserImpl;
import core.basesyntax.service.Operation;
import core.basesyntax.service.RemoveOperation;
import core.basesyntax.service.ReportWriterImpl;
import core.basesyntax.service.interfaces.FileReader;
import core.basesyntax.service.interfaces.FruitOperationHandler;
import core.basesyntax.service.interfaces.FruitRecordDtoParser;
import core.basesyntax.service.interfaces.ReportWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImplForCsv();
        FruitRecordDtoParser parser = new FruitRecordDtoParserImpl();
        String fromFile = "src/main/resources/shop_instructions.csv";
        Map<String, FruitOperationHandler> fruitOperationHandlerMap = new HashMap<>();
        fruitOperationHandlerMap.put(Operation.getOperationByLetter("s")
                .getOperation(), new AddOperation());
        fruitOperationHandlerMap.put(Operation.getOperationByLetter("r")
                .getOperation(), new AddOperation());
        fruitOperationHandlerMap.put(Operation.getOperationByLetter("b")
                .getOperation(), new AddOperation());
        fruitOperationHandlerMap.put(Operation.getOperationByLetter("p")
                .getOperation(), new RemoveOperation(
                new FruitAvailabilityValidatorImpl()));
        List<FruitRecordDto> dtos = parser.parse(fileReader.readAllLinesFromFile(fromFile));
        for (FruitRecordDto dto : dtos) {
            fruitOperationHandlerMap
                    .get(dto.getOperationType())
                    .applyAction(dto);
        }
        String toFile = "src/main/resources/report.csv";
        ReportWriter reportWriter = new ReportWriterImpl();
        reportWriter.writeReport(toFile);
    }
}
