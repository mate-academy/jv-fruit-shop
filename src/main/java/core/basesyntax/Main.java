package core.basesyntax;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.file_readers.FileReaderImplForCsv;
import core.basesyntax.service.FruitAvailabilityValidatorImpl;
import core.basesyntax.service.parser.FruitRecordDtoParserImpl;
import core.basesyntax.service.Operation;
import core.basesyntax.service.report_writer.ReportWriterImpl;
import core.basesyntax.service.handlers.AddOperationStrategy;
import core.basesyntax.service.handlers.FruitOperationStrategy;
import core.basesyntax.service.handlers.RemoveOperationStrategy;
import core.basesyntax.service.file_readers.FileReader;
import core.basesyntax.service.parser.FruitRecordDtoParser;
import core.basesyntax.service.report_writer.ReportWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImplForCsv();
        FruitRecordDtoParser parser = new FruitRecordDtoParserImpl();
        String fromFile = "src/main/resources/shop_instructions.csv";
        Map<String, FruitOperationStrategy> fruitOperationHandlerMap = new HashMap<>();
        fruitOperationHandlerMap.put(Operation.getOperationByLetter("s")
                .getOperation(), new AddOperationStrategy());
        fruitOperationHandlerMap.put(Operation.getOperationByLetter("r")
                .getOperation(), new AddOperationStrategy());
        fruitOperationHandlerMap.put(Operation.getOperationByLetter("b")
                .getOperation(), new AddOperationStrategy());
        fruitOperationHandlerMap.put(Operation.getOperationByLetter("p")
                .getOperation(), new RemoveOperationStrategy(
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
