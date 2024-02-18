package core.basesyntax;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.CSvReader;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.ShopServiceStrategy;
import core.basesyntax.service.operation.BalanceHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseHandler;
import core.basesyntax.service.operation.ReturnHandler;
import core.basesyntax.service.operation.SupplyHandler;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    // HINT: In the `public static void main(String[] args)`
    // it is better to create instances of your classes,
    // and call their methods, but do not write any business logic in the `main` method!
    public static void main(String[] args) {
        Map<ShopServiceStrategy.Operation, OperationHandler> opHandlerMap = new HashMap<>();
        opHandlerMap.put(ShopServiceStrategy.Operation.BALANCE, new BalanceHandler());
        opHandlerMap.put(ShopServiceStrategy.Operation.SUPPLY, new SupplyHandler());
        opHandlerMap.put(ShopServiceStrategy.Operation.PURCHASE, new PurchaseHandler());
        opHandlerMap.put(ShopServiceStrategy.Operation.RETURN, new ReturnHandler());

        ShopServiceImpl try1 = new ShopServiceImpl(new ShopServiceStrategy(opHandlerMap),
                new StorageDaoImpl(), new CSvReader());

        String fromFile = "src/main/java/core/basesyntax/service/Operation/TryMe.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(try1.report(fromFile)))) {
            StringBuilder data = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line).append(System.lineSeparator());
            }

            System.out.println(data);
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file", e);
        }
    }
}
