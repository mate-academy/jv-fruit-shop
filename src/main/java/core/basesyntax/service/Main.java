package core.basesyntax.service;

import core.basesyntax.service.impl.CreateTransactionImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ResultServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.service.model.FruitTransaction;
import core.basesyntax.service.service.CreateTransaction;
import core.basesyntax.service.service.ReaderService;
import core.basesyntax.service.service.ResultService;
import core.basesyntax.service.service.WriteService;
import core.basesyntax.service.strategy.EvaluateResultImpl;
import core.basesyntax.service.strategy.StrategyImpl;
import java.util.List;

public class Main {
    public static final String NAME_FILE_FROM = "src/fruits.csv";
    public static final String NAME_FILE_TO = "src/fruits_result.csv";
    private static final ReaderService readerService =
            new ReaderServiceImpl();
    private static final CreateTransaction createTransaction =
            new CreateTransactionImpl();
    private static final EvaluateResultImpl EVALUATE_RESULT_IMPL =
            new EvaluateResultImpl(new StrategyImpl());
    private static final ResultService resultService = new ResultServiceImpl();
    private static final WriteService writeService = new WriteServiceImpl();
    
    public static void main(String[] args) {
        List<String[]> infoFromFIle = readerService.read(NAME_FILE_FROM);
        List<FruitTransaction> report = createTransaction.create(infoFromFIle);
        EVALUATE_RESULT_IMPL.realizePattern(report);
        String result = resultService.createResult();
        writeService.writeToFile(result, NAME_FILE_TO);
    }
}
