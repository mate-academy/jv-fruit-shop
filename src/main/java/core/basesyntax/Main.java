package core.basesyntax;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.TypeOfOperation;
import core.basesyntax.services.FileReaderService;
import core.basesyntax.services.FileWriterService;
import core.basesyntax.services.FruitDtoParser;
import core.basesyntax.services.FruitService;
import core.basesyntax.services.implementation.FileReaderImpl;
import core.basesyntax.services.implementation.FileWriterImpl;
import core.basesyntax.services.implementation.FruitDtoParserImpl;
import core.basesyntax.services.implementation.FruitServiceImpl;
import core.basesyntax.services.operations.OperationBalance;
import core.basesyntax.services.operations.OperationHandler;
import core.basesyntax.services.operations.OperationPurchase;
import core.basesyntax.services.operations.OperationSupply;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_FOR_READ = "src/main/resources/fruits.csv";
    private static final String FILE_FOR_WRITE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<TypeOfOperation, OperationHandler> handlerOperations = new HashMap<>();
        handlerOperations.put(TypeOfOperation.BALANCE, new OperationBalance());
        handlerOperations.put(TypeOfOperation.SUPPLY, new OperationSupply());
        handlerOperations.put(TypeOfOperation.RETURN, new OperationSupply());
        handlerOperations.put(TypeOfOperation.PURCHASE, new OperationPurchase());

        FileReaderService fileReaderService = new FileReaderImpl();
        List<String> infoFromFile = fileReaderService.read(FILE_FOR_READ);

        FruitDtoParser transaction = new FruitDtoParserImpl();
        List<FruitDto> fruitDtos = transaction.parseFruitDto(infoFromFile);

        FruitService fruitService = new FruitServiceImpl(handlerOperations);
        fruitService.applyOperationsOnFruitsDto(fruitDtos);
        String reportInfo = fruitService.makeReport();

        FileWriterService fileWriterService = new FileWriterImpl();
        fileWriterService.write(reportInfo, FILE_FOR_WRITE);
    }
}
