package core.basesyntax;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import operation.Operation;
import operation.OperationBalance;
import operation.OperationPurchase;
import operation.OperationReturn;
import operation.OperationStrategy;
import operation.OperationStrategyImpl;
import operation.OperationSupply;
import operation.OperationType;
import parse.data.service.DataParse;
import parse.data.service.DataParseImpl;
import user.service.UserInterface;
import user.service.UserInterfaceImpl;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        Map<OperationType, Operation> operationMap = new HashMap<>();
        operationMap.put(OperationType.BALANCE, new OperationBalance());
        operationMap.put(OperationType.PURCHASE, new OperationPurchase());
        operationMap.put(OperationType.RETURN, new OperationReturn());
        operationMap.put(OperationType.SUPPLY, new OperationSupply());
        OperationStrategy strategy = new OperationStrategyImpl(operationMap);
        DataParse parse = new DataParseImpl(strategy);
        UserInterface userInterface = new UserInterfaceImpl(parse);
        LocalDate date = LocalDate.now();
        String fromPath = "src/main/resources/inputFile.csv";
        String toPath = "src/main/resources/dayReport.csv";
        System.out.println(userInterface.getReport(fromPath, toPath, date));
    }

}
