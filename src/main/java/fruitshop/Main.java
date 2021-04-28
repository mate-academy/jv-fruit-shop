package fruitshop;

import fruitshop.dao.FruitStorageDaoImpl;
import fruitshop.model.dto.FruitDto;
import fruitshop.model.dto.ReportDto;
import fruitshop.service.FruitDtoParser;
import fruitshop.service.FruitDtoParserImpl;
import fruitshop.service.FruitService;
import fruitshop.service.FruitServiceImpl;
import fruitshop.service.ReportService;
import fruitshop.service.ReportServiceImpl;
import fruitshop.service.files.ReadService;
import fruitshop.service.files.ReadServiceImpl;
import fruitshop.service.files.WriteService;
import fruitshop.service.files.WriteServiceImpl;
import fruitshop.service.operation.OperationHandler;
import fruitshop.service.operation.OperationType;
import fruitshop.service.operation.StorageDecreaseHandler;
import fruitshop.service.operation.StorageIncreaseHandler;
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
        List<FruitDto> fruitDtoList = fruitDtoParser.parse(fruitDataLines);
        FruitService fruitService = new FruitServiceImpl(operationMap);
        for (FruitDto fruitDto : fruitDtoList) {
            fruitService.get(fruitDto.getOperationType()).apply(fruitDto);
        }
        ReportDto reportDto = new FruitStorageDaoImpl().getDataFromStorage();
        ReportService reportService = new ReportServiceImpl();
        String reportString = reportService.generateReport(reportDto);
        WriteService writeService = new WriteServiceImpl();
        writeService.writeToFile(reportString, "src/main/resources/output.csv");
    }
}
