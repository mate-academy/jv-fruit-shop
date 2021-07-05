package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.OperationType;
import model.dto.FruitRecordDto;
import service.FileService;
import service.FruitService;
import service.FruitStrategy;
import service.OperationHandler;
import service.ParserService;
import service.ReportService;
import service.impl.AddOperation;
import service.impl.BalanceOperation;
import service.impl.FileServiceImpl;
import service.impl.FruitServiceImpl;
import service.impl.FruitStrategyImpl;
import service.impl.ParserServiceImpl;
import service.impl.RemoveOperation;
import service.impl.ReportServiceImpl;
import service.impl.ReturnOperation;

public class ApplicationRun {
    private static final String PATH_SOURCE_FILE = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/output.csv";
    private static final Map<OperationType, OperationHandler> fruitOperationsServiceMap
            = new HashMap<>();

    static {
        fruitOperationsServiceMap.put(OperationType.BALANCE, new BalanceOperation());
        fruitOperationsServiceMap.put(OperationType.SUPPLY, new AddOperation());
        fruitOperationsServiceMap.put(OperationType.PURCHASE, new RemoveOperation());
        fruitOperationsServiceMap.put(OperationType.RETURN, new ReturnOperation());
    }

    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        List<String> stringsFromFile = fileService.readFromCsvFile(PATH_SOURCE_FILE);
        ParserService parserService = new ParserServiceImpl();
        List<FruitRecordDto> fruitDtos = parserService.parseToDto(stringsFromFile);
        FruitStrategy fruitStrategy = new FruitStrategyImpl(fruitOperationsServiceMap);
        FruitService fruitService = new FruitServiceImpl(fruitStrategy);
        fruitService.saveDto(fruitDtos);
        ReportService reportService = new ReportServiceImpl();
        fileService.writeToCsvFile(OUTPUT_FILE_NAME, reportService.makeReport());
    }
}
