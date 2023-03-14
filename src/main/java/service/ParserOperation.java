package service;

import java.util.List;
import model.TransactionDto;

public interface ParserOperation {
    List<TransactionDto> parserOperation(List<String> line);
}
