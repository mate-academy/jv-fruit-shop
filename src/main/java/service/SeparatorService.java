package service;

import java.util.List;
import java.util.Map;
import model.Operation;
import model.Transaction;
import strategy.OperationHandler;

public interface SeparatorService {

    List<Transaction> getTransactionsList(List<String> readLines, Map<Operation,
                                          OperationHandler> operationHandlerMap);
}
