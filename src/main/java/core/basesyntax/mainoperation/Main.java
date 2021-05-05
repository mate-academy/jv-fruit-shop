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
import core.basesyntax.service.impl.SaverDataToStorage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<String> linesFromFile = new FileReaderImpl().readFile("Operations.csv");
        ApplierFruitsToStorage addHandler = new AddHandlerImpl();
        ApplierFruitsToStorage purchaseHandler = new PurchaseFruitHandlerImpl();
        Map<OperationType, ApplierFruitsToStorage> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(OperationType.BALANCE, addHandler);
        operationHandlerMap.put(OperationType.RETURN, addHandler);
        operationHandlerMap.put(OperationType.SUPPLY, addHandler);
        operationHandlerMap.put(OperationType.PURCHASE, purchaseHandler);
        List<FruitRecordDto> fruitDtos = new FruitRecordDtoParserImpl().parse(linesFromFile);
        new SaverDataToStorage().saveDataToStorage(fruitDtos, operationHandlerMap);
        String report = new ReportHandlerImpl().makeReport();
        new FileWriterImpl().writeToFile(report, "Report.csv");
    }
}
