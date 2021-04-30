import core.basesyntax.dto.FruitDto;
import core.basesyntax.fruitoperationstrategy.FruitStrategy;
import core.basesyntax.fruitoperationstrategy.FruitStrategyImpl;
import core.basesyntax.operations.Operation;
import core.basesyntax.service.operationwithdata.AddOperation;
import core.basesyntax.service.operationwithdata.FruitOperationHandler;
import core.basesyntax.service.operationwithdata.FruitOperationService;
import core.basesyntax.service.operationwithdata.OperationHandler;
import core.basesyntax.service.operationwithdata.SubtractOperation;
import core.basesyntax.service.parser.FruitParserDto;
import core.basesyntax.service.readandwrite.ReaderService;
import core.basesyntax.service.readandwrite.ReaderServiceImpl;
import core.basesyntax.service.readandwrite.ReportWriter;
import core.basesyntax.service.readandwrite.ReportWriterImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String READ_PATH = "src\\main\\resources\\shop.csv";
    private static final String WRITE_PATH = "report.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> list = readerService.readFile(READ_PATH);

        FruitParserDto fruitParserDto = new FruitParserDto();
        FruitOperationService addOperation = new AddOperation();
        FruitOperationService subtractOperation = new SubtractOperation();
        Map<Operation, FruitOperationService> operationServiceMap = new HashMap<>();
        operationServiceMap.put(Operation.b, addOperation);
        operationServiceMap.put(Operation.p, subtractOperation);
        operationServiceMap.put(Operation.r, addOperation);
        operationServiceMap.put(Operation.s, addOperation);

        FruitStrategy fruitStrategy = new FruitStrategyImpl(operationServiceMap);
        OperationHandler operationHandler = new FruitOperationHandler(fruitStrategy);
        List<FruitDto> fruitDtos = fruitParserDto.parseInformation(list);
        operationHandler.operationProcessing(fruitDtos);

        ReportWriter reportWriter = new ReportWriterImpl();
        reportWriter.writeReport(WRITE_PATH);
    }
}

