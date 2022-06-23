package servise;

import java.util.List;

public interface TransactionService {
    void process(List<String> records);
}
