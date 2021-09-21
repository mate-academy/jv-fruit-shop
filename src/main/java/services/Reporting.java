package services;

import java.util.List;
import model.TransactionDto;

public interface Reporting {
    List<String> createReport(List<TransactionDto> storage);
}
