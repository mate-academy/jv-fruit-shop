package service;

import fruitscontent.FruitsContent;
import java.util.List;

public interface ParserOperationService {
    List<FruitsContent> parseContentForOperations(List<String> inputData);
}
