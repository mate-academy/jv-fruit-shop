package core.service;

import core.model.FruitTransaction;
import java.util.List;

public interface DataParserService {
    List<FruitTransaction> parseList(List<String> dataFromFile);

}
