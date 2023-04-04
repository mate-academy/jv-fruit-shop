package core.basesyntax;

import core.basesyntax.Service.*;
import core.basesyntax.Service.HandlerFruits.*;
import core.basesyntax.Service.InputOutput.FileReadInput;
import core.basesyntax.Service.InputOutput.FileReadInputImp;
import core.basesyntax.Service.InputOutput.FileWriteOutput;
import core.basesyntax.Service.InputOutput.FileWriteOutputImp;
import core.basesyntax.model.FruitTransaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String INPUT_FILE_FRUIT = "src/main/java/core/basesyntax/inputOutputFiles/inputFileFruits.csv";
        String OUTPUT_FILE_FRUIT = "src/main/java/core/basesyntax/inputOutputFiles/outputFileFruits.csv";

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
        List<FruitTransaction> transactionList = toFruitTransaction.linesToFruitTransaction(linesFruitsString);

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
