package fruitoperations;

import fruittransaction.Products;
import java.util.List;

public interface FruitOperations {
    List<String> operation(List<Products> products);

    void writeDataInFile(List<String> dataForFile, String nameForNewFile);
}
