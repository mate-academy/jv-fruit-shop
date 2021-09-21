package core.basesyntax;

import core.basesyntax.model.FruitOperation;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.impl.FileServiceImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitOpParser;
import core.basesyntax.service.impl.FruitOpValidator;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.operationhandlersimpls.BalanceOperation;
import core.basesyntax.service.impl.operationhandlersimpls.PurchaseOperation;
import core.basesyntax.service.impl.operationhandlersimpls.ReturnOperation;
import core.basesyntax.service.impl.operationhandlersimpls.SupplyOperation;
import core.basesyntax.service.interfaces.OperationHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String sourceFile = "src/main/resources/filetest";
    private static final String resultFile = "src/main/resources/result.csv";

    public static void main(String[] args) {
        Map<OperationType, OperationHandler> map = new HashMap<>();
        map.put(OperationType.BALANCE, new BalanceOperation());
        map.put(OperationType.PURCHASE, new PurchaseOperation());
        map.put(OperationType.RETURN, new ReturnOperation());
        map.put(OperationType.SUPPLY, new SupplyOperation());
        FileServiceImpl fileService = new FileServiceImpl();
        List<String> data = fileService.readFile(sourceFile);
        FruitOpValidator fruitOperationValidator = new FruitOpValidator();
        FruitOpParser fruitOpParser = new FruitOpParser();
        List<FruitOperation> dtoList = new ArrayList<>();
        for (String line : data) {
            try {
                fruitOperationValidator.validate(line);
                dtoList.add(fruitOpParser.parse(line));
            } catch (ValidationException e) {
                throw new RuntimeException("Unale to validate " + data);
            }
        }
        for (FruitOperation dto : dtoList) {
            OperationHandler operationHandler = map.get(OperationType
                    .getOperation(dto.getOperation()));
            operationHandler.apply(dto);
        }
        ReportGeneratorImpl reportGenerator = new ReportGeneratorImpl();
        String dataForReport = reportGenerator.createDataForReport();
        FileWriterImpl fileWriter = new FileWriterImpl();
        fileWriter.recordDataToFile(resultFile, dataForReport);
    }
}
