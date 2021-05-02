package fruitshop;

import fruitshop.dao.FruitStorageDaoImpl;
import fruitshop.model.dto.FruitOperationDto;
import fruitshop.model.dto.ReportDto;
import fruitshop.service.FruitDtoParser;
import fruitshop.service.FruitDtoParserImpl;
import fruitshop.service.FruitService;
import fruitshop.service.FruitServiceImpl;
import fruitshop.service.ReportService;
import fruitshop.service.ReportServiceImpl;
import fruitshop.service.file.ReadService;
import fruitshop.service.file.ReadServiceImpl;
import fruitshop.service.file.WriteService;
import fruitshop.service.file.WriteServiceImpl;
import fruitshop.service.shopoperation.OperationHandler;
import fruitshop.service.shopoperation.OperationType;
import fruitshop.service.shopoperation.StorageDecreaseHandler;
import fruitshop.service.shopoperation.StorageIncreaseHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<OperationType, OperationHandler> operationMap = new HashMap<>();
        operationMap.put(OperationType.BALANCE,
                new StorageIncreaseHandler(new FruitStorageDaoImpl()));
        operationMap.put(OperationType.SUPPLY,
                new StorageIncreaseHandler(new FruitStorageDaoImpl()));
        operationMap.put(OperationType.RETURN,
                new StorageIncreaseHandler(new FruitStorageDaoImpl()));
        operationMap.put(OperationType.PURCHASE,
                new StorageDecreaseHandler(new FruitStorageDaoImpl()));
        ReadService readService = new ReadServiceImpl();
        List<String> fruitDataLines = readService.readFromFile("src/main/resources/input.csv");
        FruitDtoParser fruitDtoParser = new FruitDtoParserImpl();
        List<FruitOperationDto> fruitOperationDtoList = fruitDtoParser.parse(fruitDataLines);
        FruitService fruitService = new FruitServiceImpl(operationMap);
        for (FruitOperationDto fruitOperationDto : fruitOperationDtoList) {
            fruitService.getOperation(fruitOperationDto.getOperationType())
                    .apply(fruitOperationDto);
        }
        ReportDto reportDto = new FruitStorageDaoImpl().getDataReportFromStorage();
        ReportService reportService = new ReportServiceImpl();
        String reportString = reportService.generateReport(reportDto);
        WriteService writeService = new WriteServiceImpl();
        writeService.writeToFile(reportString, "src/main/resources/output.csv");
    }
}
