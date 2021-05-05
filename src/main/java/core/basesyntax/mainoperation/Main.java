package core.basesyntax.mainoperation;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.model.dto.impl.FileReaderImpl;
import core.basesyntax.model.dto.impl.FileWriterImpl;
import core.basesyntax.model.dto.impl.ReportHandlerImpl;
import core.basesyntax.service.ApplierFruitsToStorage;
import core.basesyntax.service.fileservice.impl.FruitRecordDtoParserImpl;
import core.basesyntax.service.impl.AddHandlerImpl;
import core.basesyntax.service.impl.OperationType;
import core.basesyntax.service.impl.PurchaseFruitHandlerImpl;
import core.basesyntax.service.impl.SaverDataToStorageImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<String> linesFromFile = new FileReaderImpl().readFile("Operations.csv");
        ApplierFruitsToStorage addHandler = new AddHandlerImpl();
        ApplierFruitsToStorage purchaseHandler = new PurchaseFruitHandlerImpl();
        Map<OperationType, ApplierFruitsToStorage> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(OperationType.BALANCE, addHandler);
        operationStrategyMap.put(OperationType.RETURN, addHandler);
        operationStrategyMap.put(OperationType.SUPPLY, addHandler);
        operationStrategyMap.put(OperationType.PURCHASE, purchaseHandler);
        List<FruitRecordDto> fruitDtos = new FruitRecordDtoParserImpl().parse(linesFromFile);
        new SaverDataToStorageImpl().saveDataToStorage(fruitDtos, operationStrategyMap);
        String report = new ReportHandlerImpl().makeReport();
        new FileWriterImpl().writeToFile(report, "Report.csv");
    }
}
