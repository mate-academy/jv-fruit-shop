package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.dto.FruitRecordDto;
import service.FruitOperationsService;
import service.ParserService;
import service.FileService;
import service.ReportService;
import service.impl.AddOperation;
import service.impl.ParserServiceImpl;
import service.impl.FileServiceImpl;
import service.impl.RemoveOperation;
import service.impl.ReportServiceImpl;

public class ApplicationRun {
    private static final String SUPPLY = "s";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";
    private static final String PATH_SOURCE_FILE = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/output.csv";
    private static final Map<String, FruitOperationsService> fruitOperationsServiceMap
            = new HashMap<>();

    static {
        fruitOperationsServiceMap.put(SUPPLY, new AddOperation());
        fruitOperationsServiceMap.put(PURCHASE, new RemoveOperation());
        fruitOperationsServiceMap.put(RETURN, new AddOperation());
    }

    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        List<String> stringsFromFile = fileService.readFromCsvFile(PATH_SOURCE_FILE);
        ParserService parserService = new ParserServiceImpl();
        List<FruitRecordDto> fruitDtos = parserService.parseToDto(stringsFromFile);
        for (FruitRecordDto dto : fruitDtos) {
            fruitOperationsServiceMap.get(dto.getOperationType())
                                                       .apply(dto);
        }
        ReportService reportService = new ReportServiceImpl();
        fileService.writeToCsvFile(OUTPUT_FILE_NAME, reportService.makeStockReportForCsvFile());
    }
}
