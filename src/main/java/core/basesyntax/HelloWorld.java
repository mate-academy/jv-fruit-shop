package core.basesyntax;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.Operation.*;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.ShopServiceStrategy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    // HINT: In the `public static void main(String[] args)` it is better to create instances of your classes, 
    // and call their methods, but do not write any business logic in the `main` method!
    public static void main(String[] args) {
        Map<ShopServiceStrategy.Operation, OperationHandler> OpHandlerMap = new HashMap<>();
        OpHandlerMap.put(ShopServiceStrategy.Operation.BALANCE, new BalanceHandler());
        OpHandlerMap.put(ShopServiceStrategy.Operation.SUPPLY, new SupplyHandler());
        OpHandlerMap.put(ShopServiceStrategy.Operation.PURCHASE, new PurchaseHandler());
        OpHandlerMap.put(ShopServiceStrategy.Operation.RETURN, new ReturnHandler());

        ShopServiceImpl try1 = new ShopServiceImpl(new ShopServiceStrategy(OpHandlerMap), new StorageDaoImpl());
        String fromFile = "C:\\Users\\admin\\IdeaProjects\\jv-fruit-shop\\src\\main\\java\\core\\basesyntax\\service\\Operation\\try.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(try1.report(fromFile)))) {
            StringBuilder data = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("type,fruit,")) {
                    continue;
                }
                data.append(line).append(System.lineSeparator());
            }

            System.out.println(data);
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file", e);
        }
    }
}
