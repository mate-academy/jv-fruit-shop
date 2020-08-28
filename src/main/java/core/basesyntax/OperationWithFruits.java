package core.basesyntax;

import core.basesyntax.exeptions.NotEnoughFruitsException;
import java.util.ArrayList;
import java.util.List;

public class OperationWithFruits {

    private RemoveFruit buyingOperation = new RemoveFruit();
    private AddFruit addOperation = new AddFruit();

    public List<Fruit> operationWithFruits(List<Transaction> transaction)
            throws NotEnoughFruitsException {
        List<Fruit> fruitsAvailable = new ArrayList<>();
        for (int i = 0; i < transaction.size(); i++) {
            String operationType = transaction.get(i).getTypeOfOperation();
            switch (operationType) {
                case "s":
                    fruitsAvailable = addOperation
                            .operation(fruitsAvailable, transaction.get(i));
                    break;
                case "b":
                    fruitsAvailable = buyingOperation
                            .operation(fruitsAvailable, transaction.get(i));
                    break;
                case "r":
                    fruitsAvailable = addOperation
                            .operation(fruitsAvailable, transaction.get(i));
                    break;
                default:
                    break;
            }
        }
        return fruitsAvailable;
    }
}
