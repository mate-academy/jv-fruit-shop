package core.basesyntax;

import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Storage;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitOperationHandler;
import core.basesyntax.service.OperationType;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.implementation.DecreaseOperationImpl;
import core.basesyntax.service.implementation.FileReaderImpl;
import core.basesyntax.service.implementation.FileWriterImpl;
import core.basesyntax.service.implementation.FruitParserImpl;
import core.basesyntax.service.implementation.IncreaseOperationImpl;
import core.basesyntax.service.implementation.ReportServiceImpl;
import core.basesyntax.service.implementation.SetOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/InputFile.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/OutputFile.csv";

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> dataFromFile = fileReader.readFromFile(INPUT_FILE_PATH);

        List<FruitRecordDto> listOfRecord = new FruitParserImpl().parse(dataFromFile);
        Map<OperationType, FruitOperationHandler> handlers = fillMap();

        for (FruitRecordDto fruitRecordDto : listOfRecord) {
            handlers.get(fruitRecordDto.getOperationType()).apply(fruitRecordDto);
        }

        ReportService reportService = new ReportServiceImpl();
        String reportMessage = reportService.createReport(Storage.getFruits());

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(reportMessage, OUTPUT_FILE_PATH);
    }

    private static Map<OperationType, FruitOperationHandler> fillMap() {
        Map<OperationType, FruitOperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(OperationType.BALANCE, new SetOperation());
        handlerMap.put(OperationType.PURCHASE, new DecreaseOperationImpl());
        handlerMap.put(OperationType.RETURN, new IncreaseOperationImpl());
        handlerMap.put(OperationType.SUPPLY, new IncreaseOperationImpl());
        return handlerMap;
    }
}
