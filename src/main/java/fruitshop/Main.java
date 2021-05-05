package fruitshop;

import fruitshop.dao.FruitStorageDao;
import fruitshop.dao.FruitStorageDaoImpl;
import fruitshop.model.Fruit;
import fruitshop.model.dto.FruitOperationDto;
import fruitshop.service.FruitDtoParser;
import fruitshop.service.FruitDtoParserImpl;
import fruitshop.service.FruitService;
import fruitshop.service.FruitServiceImpl;
import fruitshop.service.ReportService;
import fruitshop.service.ReportServiceImpl;
import fruitshop.service.shopoperation.OperationHandler;
import fruitshop.service.shopoperation.OperationType;
import fruitshop.service.shopoperation.StorageDecreaseHandler;
import fruitshop.service.shopoperation.StorageIncreaseHandler;
import fruitshop.util.ReadService;
import fruitshop.util.ReadServiceImpl;
import fruitshop.util.WriteService;
import fruitshop.util.WriteServiceImpl;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();
        OperationHandler storageIncreaseHandler = new StorageIncreaseHandler(
                fruitStorageDao);
        Map<OperationType, OperationHandler> operationMap = new HashMap<>();
        operationMap.put(OperationType.BALANCE, storageIncreaseHandler);
        operationMap.put(OperationType.SUPPLY, storageIncreaseHandler);
        operationMap.put(OperationType.RETURN, storageIncreaseHandler);
        operationMap.put(OperationType.PURCHASE, new StorageDecreaseHandler(
                fruitStorageDao));

        ReadService readService = new ReadServiceImpl();
        List<String> fruitDataLines = readService.readFromFile("src/main/resources/input.csv");
        FruitDtoParser fruitDtoParser = new FruitDtoParserImpl();
        List<FruitOperationDto> fruitOperationDtoList = fruitDtoParser.parse(fruitDataLines);
        FruitService fruitService = new FruitServiceImpl(operationMap);

        for (FruitOperationDto fruitOperationDto : fruitOperationDtoList) {
            fruitService.getOperation(fruitOperationDto.getOperationType())
                    .apply(fruitOperationDto);
        }
        Set<Map.Entry<Fruit, BigDecimal>> report = new FruitStorageDaoImpl()
                .getDataReportFromStorage();
        ReportService reportService = new ReportServiceImpl();
        String reportString = reportService.generateReport(report);
        WriteService writeService = new WriteServiceImpl();
        writeService.writeToFile(reportString, "src/main/resources/output.csv");
    }
}
