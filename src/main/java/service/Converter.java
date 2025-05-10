package service;

import java.util.List;
import model.Transaction;

public interface Converter {
    List<Transaction> convertTransaction(List<String> reportLines);
}
