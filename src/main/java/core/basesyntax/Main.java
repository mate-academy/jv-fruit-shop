package core.basesyntax;

import core.basesyntax.dataservises.ReadFromFiles;
import core.basesyntax.dataservises.Reader;
import core.basesyntax.dataservises.WriteToFile;
import core.basesyntax.dataservises.Writer;
import core.basesyntax.model.TransferDto;
import core.basesyntax.operationhanlerservises.BalanceHandler;
import core.basesyntax.operationhanlerservises.OperationHandler;
import core.basesyntax.operationhanlerservises.PurchaseHandler;
import core.basesyntax.operationhanlerservises.ReturnHandler;
import core.basesyntax.operationhanlerservises.SupplayHandler;
import core.basesyntax.servises.DataServise;
import core.basesyntax.servises.DataServiseImpl;
import core.basesyntax.servises.Mapper;
import core.basesyntax.servises.OperationStrategy;
import core.basesyntax.servises.OperationStrategyImpl;
import core.basesyntax.servises.OperationType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INTO_FILE = "src\\main\\java\\core\\"
            + "basesyntax\\sourses\\inputFile.csv";
    private static final String OUT_FILE = "src\\main\\java\\core\\"
            + "basesyntax\\sourses\\outputFile.csv";

    public static void main(String[] args) {
        Map<OperationType, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(OperationType.BALANCE, new BalanceHandler());
        operationHandlerMap.put(OperationType.SUPPLY, new SupplayHandler());
        operationHandlerMap.put(OperationType.RETURN, new ReturnHandler());
        operationHandlerMap.put(OperationType.PURCHASE, new PurchaseHandler());
        Reader reader = new ReadFromFiles(INTO_FILE);
        Writer writer = new WriteToFile(OUT_FILE);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        Map<String, Integer> storage = new HashMap<>();
        Mapper mapper = new Mapper();
        List<TransferDto> dtos = mapper.apply(reader.read());
        DataServise dataServise = new DataServiseImpl();
        writer.write(dataServise.report(operationStrategy, dtos, storage));
    }
}

