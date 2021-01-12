package servise;

import exception.FruitShopException;
import java.util.List;

public interface ReaderFromFile {
    List<String> readFromFile() throws FruitShopException;
}
