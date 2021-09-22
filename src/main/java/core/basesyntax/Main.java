package core.basesyntax;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.ParserImpl;
import core.basesyntax.service.ReportCreatorImpl;
import core.basesyntax.service.files.FileReaderImpl;
import core.basesyntax.service.files.FileWriterWithResults;
import core.basesyntax.service.files.FileWriterWithResultsImpl;
import core.basesyntax.service.files.ValidatorImpl;
import core.basesyntax.service.operations.AdditionHendlerImpl;
import core.basesyntax.service.operations.OperationHendler;
import core.basesyntax.service.operations.SubstractionHendlerImpl;
import core.basesyntax.service.strategy.OperationsStrategy;
import core.basesyntax.service.strategy.OperationsStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_PATH = "src/main/java/core/basesyntax/recources/input.csv";
    private static final String OUTPUT_PATH = "src/main/java/core/basesyntax/recources/output.csv";

    public static void main(String[] args) {
        List<String> informationFromInput = new FileReaderImpl().readFile(INPUT_PATH);
        ValidatorImpl validator = new ValidatorImpl();
        validator.isValid(informationFromInput);
        Map<TransactionDto.OperationTypes, OperationHendler> strategy = new HashMap<>();
        strategy.put(TransactionDto.OperationTypes.BALANCE, new AdditionHendlerImpl());
        strategy.put(TransactionDto.OperationTypes.PURCHASE, new SubstractionHendlerImpl());
        strategy.put(TransactionDto.OperationTypes.RETURN, new AdditionHendlerImpl());
        strategy.put(TransactionDto.OperationTypes.SUPPLY, new AdditionHendlerImpl());
        OperationsStrategy operationsStrategy = new OperationsStrategyImpl(strategy);
        FruitShopService fruitShopService = new FruitShopServiceImpl(operationsStrategy);
        List<TransactionDto> parsedInformation = new ParserImpl().parser(informationFromInput);
        fruitShopService.applyOperationsOnFruitsDto(parsedInformation);
        List<String> outputInformation = new ReportCreatorImpl().createReport();
        FileWriterWithResults fileWriter = new FileWriterWithResultsImpl();
        fileWriter.writeResultToFile(OUTPUT_PATH, outputInformation);
    }
}
