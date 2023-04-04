package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.OperationHandlerImp;
import core.basesyntax.service.OutputService;
import core.basesyntax.service.OutputServiceImp;
import core.basesyntax.service.ToFruitTransaction;
import core.basesyntax.service.ToFruitTransactionImp;
import core.basesyntax.service.handlerfruits.BalanceFruitsHandlerImp;
import core.basesyntax.service.handlerfruits.FruitsHandler;
import core.basesyntax.service.handlerfruits.PurchaseFruitsHandlerImp;
import core.basesyntax.service.handlerfruits.ReturnFruitsHandlerImp;
import core.basesyntax.service.handlerfruits.SupplyFruitsHandlerImp;
import core.basesyntax.service.inputoutput.FileReadInput;
import core.basesyntax.service.inputoutput.FileReadInputImp;
import core.basesyntax.service.inputoutput.FileWriteOutput;
import core.basesyntax.service.inputoutput.FileWriteOutputImp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_FRUIT =
            "src/main/java/core/basesyntax/inputOutputFiles/inputFileFruits.csv";
    private static final String OUTPUT_FILE_FRUIT =
            "src/main/java/core/basesyntax/inputOutputFiles/outputFileFruits.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, FruitsHandler> handlerMap = new HashMap<>();
        handlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceFruitsHandlerImp());
        handlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseFruitsHandlerImp());
        handlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyFruitsHandlerImp());
        handlerMap.put(FruitTransaction.Operation.RETURN, new ReturnFruitsHandlerImp());
        OperationHandler operationHandler = new OperationHandlerImp(handlerMap);

        FileReadInput fileReadInput = new FileReadInputImp();
        FileWriteOutput fileWriteOutput = new FileWriteOutputImp();

        List<String> linesFruitsString = fileReadInput.readFile(INPUT_FILE_FRUIT);
        ToFruitTransaction toFruitTransaction = new ToFruitTransactionImp();
        List<FruitTransaction> transactionList =
                toFruitTransaction.linesToFruitTransaction(linesFruitsString);

        for (FruitTransaction fruitTransaction : transactionList) {
            FruitsHandler handler = operationHandler
                    .getEnum(fruitTransaction.getOperation());
            handler.handle(fruitTransaction);
        }

        OutputService reportService = new OutputServiceImp();
        String report = reportService.outputString();
        fileWriteOutput.write(OUTPUT_FILE_FRUIT, report);
    }
}
