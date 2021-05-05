package core.basesyntax;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitOperationHandler;
import core.basesyntax.service.FruitRecordDtoParser;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.impl.BalanceOperation;
import core.basesyntax.service.impl.FileOperationImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImplementation;
import core.basesyntax.service.impl.FruitRecordDtoParserImpl;
import core.basesyntax.service.impl.PurchaseOperation;
import core.basesyntax.service.impl.ReturnOperation;
import core.basesyntax.service.impl.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationRunner {
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";
    private static final String INPUT_FILE_PATH = "src/main/resources/fruitStorageInfo.csv";

    public static void main(String[] args) {
        Map<String, FruitOperationHandler> handlers = new HashMap<>();
        handlers.put("b", new BalanceOperation());
        handlers.put("p", new PurchaseOperation());
        handlers.put("r", new ReturnOperation());
        handlers.put("s", new SupplyOperation());
        FileReaderService fileReader = new FileReaderImpl();
        FruitRecordDtoParser parser = new FruitRecordDtoParserImpl();
        OperationStrategy operationStrategy = new FileOperationImpl(handlers);
        List<FruitRecordDto> dtos = parser.parse(fileReader.readFromFile(INPUT_FILE_PATH));
        for (FruitRecordDto dto : dtos) {
            handlers.get(dto.getOperationType()).apply(dto);
        }
        String data = operationStrategy.getReport();
        FileWriterService fileWriter = new FileWriterImplementation();
        fileWriter.write(data,REPORT_FILE_PATH);
    }
}
