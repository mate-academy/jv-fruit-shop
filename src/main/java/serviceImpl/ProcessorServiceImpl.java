package serviceImpl;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.ProcessorService;
import service.handler.OperationHandler;

public class ProcessorServiceImpl implements ProcessorService {

    @Override
    public void processOnData(List<FruitTransaction> transactions,
                                              Map<FruitTransaction.Operation,
                                                      OperationHandler> operation) {
        for (FruitTransaction fruitTransaction : transactions) {
            OperationHandler operationHandler =
                    operation.get(fruitTransaction.getOperation());
            if (operationHandler != null) {
                operationHandler.apply(fruitTransaction);
            } else {
                throw new RuntimeException("Couldn't be found");
            }

        }
    }
}
