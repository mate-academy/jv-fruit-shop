package service;

import java.util.List;
import model.FruitTransaction;

public interface FileParserService {
    List<FruitTransaction> parseFileInformation(List<String> lines);
}
