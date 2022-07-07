package service;

import java.util.List;

public interface TransactionProcessorService {
    void process(List<String> lines);
}
