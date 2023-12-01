package core.basesyntax.readFileService;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService{
    private static final String SEPARATOR = ",";
    private static final String FILE_HEADER = "type,fruit,quantity";
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> readFile(String inputFileName) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        File file = new File(inputFileName);
        try {
            List<String> list = Files.readAllLines(file.toPath());
            list.remove(FILE_HEADER);

            for (int i = 0; i < list.size(); i++) {
                String[] array = list.get(i).split(SEPARATOR);
                Operation operation = Operation.getOperationFromCode(array[TYPE_INDEX]);
                String food = array[FRUIT_INDEX];
                int quantity = Integer.parseInt(array[QUANTITY_INDEX]);
                if (quantity < 0) {
                    throw new RuntimeException("Quantity can't be less then 0!");
                }
                fruitTransactionList.add(new FruitTransaction(operation, food, quantity));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file named: " + inputFileName, e);
        }
        return fruitTransactionList;
    }
}
