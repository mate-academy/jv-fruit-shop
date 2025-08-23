package core.basesyntax.raportcreator;

import static core.basesyntax.model.TypeOfOperation.b;
import static core.basesyntax.model.TypeOfOperation.p;
import static core.basesyntax.model.TypeOfOperation.r;
import static core.basesyntax.model.TypeOfOperation.s;

import core.basesyntax.fruitsoperationsservice.FruitOperationServiceImpl;
import core.basesyntax.fruitsoperationsservice.FruitsOperationService;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TypeOfOperation;
import core.basesyntax.typeofoperationhandler.BalanceService;
import core.basesyntax.typeofoperationhandler.PurchaseService;
import core.basesyntax.typeofoperationhandler.ReturnService;
import core.basesyntax.typeofoperationhandler.SupplyService;
import core.basesyntax.typeofoperationhandler.TypeOfOperationService;
import core.basesyntax.typeofoperationhandler.operationservice.OperationHandler;
import core.basesyntax.typeofoperationhandler.operationservice.OperationHandlerImpl;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {

    private TypeOfOperationService balanceHandler = new BalanceService();
    private TypeOfOperationService purchaseHandler = new PurchaseService();
    private TypeOfOperationService returnHandler = new ReturnService();
    private TypeOfOperationService supplyHandler = new SupplyService();

    @Override
    public void createReport() {

        final String reportFormat = "fruit,quantity";

        Map<TypeOfOperation, TypeOfOperationService> typeOfOpeAndTypeOfOpeHandlerMap
                = new HashMap<>();
        typeOfOpeAndTypeOfOpeHandlerMap.put(b, balanceHandler);
        typeOfOpeAndTypeOfOpeHandlerMap.put(s, supplyHandler);
        typeOfOpeAndTypeOfOpeHandlerMap.put(r, returnHandler);
        typeOfOpeAndTypeOfOpeHandlerMap.put(p, purchaseHandler);
        OperationHandler operationHandler =
                new OperationHandlerImpl(typeOfOpeAndTypeOfOpeHandlerMap);
        FruitsOperationService fruitsOperationService =
                new FruitOperationServiceImpl(operationHandler);
        List<Operation> operations = fruitsOperationService.prepareProcessedDataToReport();
        String result1 = reportFormat + System.lineSeparator();
        writeToFile(result1);
        StringBuilder stringBuilder1 = new StringBuilder();
        String result2 = null;
        for (Operation operation : operations) {
            result2 = stringBuilder1.append((operation)).append(System.lineSeparator()).toString();
        }
        writeToFile(result2);
    }

    private void writeToFile(String insert) {
        File targetFile = new File("Report.csv");
        try {
            targetFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Files.write(targetFile.toPath(), insert.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file.");
        }
    }
}
