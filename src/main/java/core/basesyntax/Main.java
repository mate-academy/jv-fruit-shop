package core.basesyntax;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitOpValidator;
import core.basesyntax.service.impl.FruitRecordParser;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.operationhandlersimpls.BalanceHandler;
import core.basesyntax.service.impl.operationhandlersimpls.PurchaseHandler;
import core.basesyntax.service.impl.operationhandlersimpls.ReturnHandler;
import core.basesyntax.service.impl.operationhandlersimpls.SupplyHandler;
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
        map.put(OperationType.BALANCE, new BalanceHandler());
        map.put(OperationType.PURCHASE, new PurchaseHandler());
        map.put(OperationType.RETURN, new ReturnHandler());
        map.put(OperationType.SUPPLY, new SupplyHandler());
        FileReaderImpl fileService = new FileReaderImpl();
        List<String> data = fileService.read(sourceFile);
        FruitOpValidator fruitOperationValidator = new FruitOpValidator();
        FruitRecordParser fruitOpParser = new FruitRecordParser();
        List<FruitRecord> dtoList = new ArrayList<>();
        for (String line : data) {
            fruitOperationValidator.validate(line);
            dtoList.add(fruitOpParser.parse(line));
        }

        for (FruitRecord dto : dtoList) {
            OperationHandler operationHandler = map.get(OperationType
                    .getOperation(dto.getOperation()));
            operationHandler.apply(dto);
        }
        ReportGeneratorImpl reportGenerator = new ReportGeneratorImpl();
        String dataForReport = reportGenerator.generateReport();
        FileWriterImpl fileWriter = new FileWriterImpl();
        fileWriter.recordDataToFile(resultFile, dataForReport);
    }
}
