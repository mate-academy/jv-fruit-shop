package service;

import java.util.List;
import service.impl.TransactionDto;

public interface TransactionDtoParse {
    List<TransactionDto> parseData(List<String> data);
}
