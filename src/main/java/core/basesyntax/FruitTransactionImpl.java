package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.service.Reader;
import core.basesyntax.service.StorageActions;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.StorageActionsImpl;
import core.basesyntax.service.impl.WriterImpl;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitTransactionImpl implements FruitTransaction {
    private final OperationStrategy strategy;

    FruitTransactionImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public List<String> getDayData() {
        Reader reader = new ReaderImpl();
        return reader.readFromFile();
    }

    @Override
    public void processData(List<String> dayData) {
        List<String> data = dayData;
        data.remove(0);
        for (String datum : data) {
            String fruitType = datum.split(",")[1];
            Integer quantity = Integer.parseInt(datum.split(",")[2]);
            String procedure = strategy.getHandler(datum).getProcedure();
            operateStorage(procedure, fruitType, quantity);
        }
    }

    private void operateStorage(String procedure, String fruitType, Integer quantity) {
        StorageActions storageActions = new StorageActionsImpl();
        if (procedure.equals("Addition")) {
            storageActions.addToStorage(fruitType, quantity);
        } else {
            storageActions.removeFromStorage(fruitType, quantity);
        }
    }

    @Override
    public String generateReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity" + System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.storageContents.entrySet()) {
            stringBuilder.append(entry.getKey() + "," + entry.getValue() + System.lineSeparator());
        }
        stringBuilder.trimToSize();
        return stringBuilder.toString();
    }

    @Override
    public void writeData(String report) {
        Writer writer = new WriterImpl();
        writer.writeToFile(report);
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }
    }
}
