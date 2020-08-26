package core.basesyntax;

import core.basesyntax.exception.NotEnoughFruitException;
import core.basesyntax.model.Transaction;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FruitService {
    private static final Logger logger = LoggerFactory.getLogger(FruitService.class);
    private FruitStorage fruitStorage;

    public FruitService(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    public void fillFruitStorage(List<Transaction> transactions) {
        TransactionExecutor transactionExecutor = new TransactionExecutor(fruitStorage);
        for (int i = 0; i < transactions.size(); i++) {
            try {
                transactionExecutor.execute(transactions.get(i));
            } catch (NotEnoughFruitException e) {
                logger.error("File contains impossible operation at line " + i, e);
                throw e;
            }
        }
    }
}
