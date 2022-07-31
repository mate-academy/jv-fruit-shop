package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.AnalysisBalancesService;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.ReadFileService;
import core.basesyntax.service.ReportCreateService;
import core.basesyntax.service.WriteFileService;
import core.basesyntax.service.impl.AnalysisBalancesServiceImpl;
import core.basesyntax.service.impl.ParseServiceImpl;
import core.basesyntax.service.impl.ReadFileServiceImpl;
import core.basesyntax.service.impl.ReportCreateServiceImpl;
import core.basesyntax.service.impl.WriteFileServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.operation.AdditionalOperation;
import core.basesyntax.strategy.operation.OperationType;
import core.basesyntax.strategy.operation.SubtractionOperation;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String inputData = "src"
            + File.separator + "main"
            + File.separator + "resources"
            + File.separator + "ProductBalance.csv";
    private static final String outputData = "src"
            + File.separator + "main"
            + File.separator + "resources"
            + File.separator + "Report.csv";

    private static Map<FruitTransaction.Operation, OperationType> fruitDaoMap = new HashMap<>();
    private static List<String> lines;

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        ReadFileService readFile = new ReadFileServiceImpl();
        lines = readFile.getLineString(inputData);

        fruitDaoMap.put(FruitTransaction.Operation.BALANCE, new AdditionalOperation(fruitDao));
        fruitDaoMap.put(FruitTransaction.Operation.SUPPLY, new AdditionalOperation(fruitDao));
        fruitDaoMap.put(FruitTransaction.Operation.PURCHASE, new SubtractionOperation(fruitDao));
        fruitDaoMap.put(FruitTransaction.Operation.RETURN, new AdditionalOperation(fruitDao));

        ParseService parseService = new ParseServiceImpl();

        AnalysisBalancesService analysisBalancesService =
                new AnalysisBalancesServiceImpl(new OperationStrategy(fruitDaoMap));
        analysisBalancesService.processing(parseService.getListArrayParse(lines));

        ReportCreateService createService = new ReportCreateServiceImpl(fruitDao);

        WriteFileService writeFileService = new WriteFileServiceImpl();
        writeFileService.writeFile(outputData, createService.create());
    }
}
