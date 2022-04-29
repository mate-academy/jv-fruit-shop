package core.basesyntax;

import core.basesyntax.model.FruitOperationDto;
import core.basesyntax.service.FileService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportWriter;
import core.basesyntax.service.ShopsService;
import core.basesyntax.service.Transformation;
import core.basesyntax.service.Validator;
import core.basesyntax.service.impl.FileReading;
import core.basesyntax.service.impl.FruitDtoTransformation;
import core.basesyntax.service.impl.FruitOperationDtoValidator;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopsServiceImpl;
import core.basesyntax.service.impl.WriteReportToFile;
import core.basesyntax.service.operationstrategy.BalanceOperationHandler;
import core.basesyntax.service.operationstrategy.OperationHandler;
import core.basesyntax.service.operationstrategy.PurchaseOperationHandler;
import core.basesyntax.service.operationstrategy.ReturnOperationHandler;
import core.basesyntax.service.operationstrategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_CSV = "src/main/resources/inputFile.csv";
    private static final String REPORT_FILE_CSV = "src/main/resources/reportFile.csv";

    public static void main(String[] args) {
        FileService file = new FileReading();
        List<String> dataFromFile = file.readFile(INPUT_FILE_CSV);

        Validator<String> validator = new FruitOperationDtoValidator();
        validator.validate(dataFromFile);

        Transformation<String, FruitOperationDto> fruitTransformation
                = new FruitDtoTransformation();

        Map<FruitOperationDto.Type, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitOperationDto.Type.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitOperationDto.Type.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(FruitOperationDto.Type.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(FruitOperationDto.Type.RETURN, new ReturnOperationHandler());

        List<FruitOperationDto> dtos = fruitTransformation.transform(dataFromFile);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        ShopsService shopsService = new ShopsServiceImpl(operationStrategy);
        shopsService.updateStorage(dtos);

        ReportGenerator report = new ReportGeneratorImpl();
        String fruitReport = report.fruitReport();

        ReportWriter reportWriter = new WriteReportToFile();
        reportWriter.write(REPORT_FILE_CSV, fruitReport);
    }
}
