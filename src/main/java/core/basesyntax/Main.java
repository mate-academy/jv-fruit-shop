package core.basesyntax;

import core.basesyntax.dataservices.ReadFromFiles;
import core.basesyntax.dataservices.Reader;
import core.basesyntax.dataservices.WriteToFile;
import core.basesyntax.dataservices.Writer;
import core.basesyntax.model.TransferDto;
import core.basesyntax.operationhanlerservices.BalanceHandler;
import core.basesyntax.operationhanlerservices.OperationHandler;
import core.basesyntax.operationhanlerservices.PurchaseHandler;
import core.basesyntax.operationhanlerservices.ReturnHandler;
import core.basesyntax.operationhanlerservices.SupplayHandler;
import core.basesyntax.services.DataService;
import core.basesyntax.services.DataServiceImpl;
import core.basesyntax.services.Mapper;
import core.basesyntax.services.OperationStrategy;
import core.basesyntax.services.OperationStrategyImpl;
import core.basesyntax.services.OperationType;
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
        DataService dataService = new DataServiceImpl();
        writer.write(dataService.report(operationStrategy, dtos, storage));
    }
}

