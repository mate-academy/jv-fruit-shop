package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandlerStrategy;
import core.basesyntax.service.OperationHandlerStrategyImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImp;
import core.basesyntax.service.ToFruitTransaction;
import core.basesyntax.service.ToFruitTransactionImp;
import core.basesyntax.service.handlerfruits.BalanceFruitsHandlerImp;
import core.basesyntax.service.handlerfruits.OperationHandler;
import core.basesyntax.service.handlerfruits.PurchaseFruitsHandlerImp;
import core.basesyntax.service.handlerfruits.ReturnFruitsHandlerImp;
import core.basesyntax.service.handlerfruits.SupplyFruitsHandlerImp;
import core.basesyntax.service.inputoutput.FileReader;
import core.basesyntax.service.inputoutput.FileReaderImp;
import core.basesyntax.service.inputoutput.FileWriter;
import core.basesyntax.service.inputoutput.FileWriterImp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_FRUIT =
            "src/main/resources/inputFileFruits.csv";
    private static final String OUTPUT_FILE_FRUIT =
            "src/main/resources/outputFileFruits.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceFruitsHandlerImp());
        handlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseFruitsHandlerImp());
        handlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyFruitsHandlerImp());
        handlerMap.put(FruitTransaction.Operation.RETURN, new ReturnFruitsHandlerImp());
        OperationHandlerStrategy operationHandler = new OperationHandlerStrategyImpl(handlerMap);

        FileReader fileReadInput = new FileReaderImp();
        FileWriter fileWriteOutput = new FileWriterImp();

        List<String> linesFruitsString = fileReadInput.readFile(INPUT_FILE_FRUIT);
        ToFruitTransaction toFruitTransaction = new ToFruitTransactionImp();
        List<FruitTransaction> transactionList =
                toFruitTransaction.linesToFruitTransaction(linesFruitsString);

        for (FruitTransaction fruitTransaction : transactionList) {
            OperationHandler handler = operationHandler
                    .get(fruitTransaction.getOperation());
            handler.handle(fruitTransaction);
        }

        ReportService reportService = new ReportServiceImp();
        String report = reportService.createReport();
        fileWriteOutput.write(OUTPUT_FILE_FRUIT, report);
    }
}
