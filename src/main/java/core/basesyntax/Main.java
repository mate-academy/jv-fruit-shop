package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.dto.FruitRecordDtoParserImpl;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitOperationHandler;
import core.basesyntax.service.OperationType;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.implementation.AddOperation;
import core.basesyntax.service.implementation.FileReaderImpl;
import core.basesyntax.service.implementation.FileWriterImpl;
import core.basesyntax.service.implementation.ReduceOperation;
import core.basesyntax.service.implementation.ReportServiceImpl;
import core.basesyntax.service.implementation.SetOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/FruitInput.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/FruitOutput.csv";

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> fileInfo = fileReader.read(INPUT_FILE_NAME);
        List<FruitRecordDto> listOfRecord = new FruitRecordDtoParserImpl().parse(fileInfo);
        Map<OperationType, FruitOperationHandler> handlers = fillMap();

        for (FruitRecordDto fruitRecordDto : listOfRecord) {
            handlers.get(fruitRecordDto.getOperationType()).apply(fruitRecordDto);
        }

        ReportService reportService = new ReportServiceImpl();
        String reportMessage = reportService.createReport(Storage.fruitsContainer);

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(reportMessage, OUTPUT_FILE_NAME);
    }

    private static Map<OperationType, FruitOperationHandler> fillMap() {
        Map<OperationType, FruitOperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(OperationType.BALANCE, new SetOperation());
        handlerMap.put(OperationType.PURCHASE, new ReduceOperation());
        handlerMap.put(OperationType.RETURN, new AddOperation());
        handlerMap.put(OperationType.SUPPLY, new AddOperation());
        return handlerMap;
    }

}
