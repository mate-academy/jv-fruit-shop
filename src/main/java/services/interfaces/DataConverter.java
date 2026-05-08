package services.interfaces;

import java.io.IOException;
import java.util.List;
import model.FruitTransaction;

public interface DataConverter {
    List<FruitTransaction> convertToFruitTransaction(List<String> list) throws IOException;
}
