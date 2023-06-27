package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.exception.InvalidFruitTransactionException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransactionReport;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.FruitTransactionValidator;
import core.basesyntax.service.ftoperation.FruitTransactionOperationStrategy;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DefaultFruitTransactionService implements FruitTransactionService {
    private final FruitTransactionValidator fruitTransactionValidator;
    private final FruitTransactionDao fruitTransactionDao;
    private final FruitTransactionOperationStrategy fruitTransactionOperationStrategy;

    public DefaultFruitTransactionService(FruitTransactionValidator ftValidator,
                                          FruitTransactionDao ftDao,
                                          FruitTransactionOperationStrategy ftOperationStrategy) {
        this.fruitTransactionValidator = ftValidator;
        this.fruitTransactionDao = ftDao;
        this.fruitTransactionOperationStrategy = ftOperationStrategy;
    }

    @Override
    public void registerSingleTransaction(FruitTransaction fruitTransaction) {
        if (!fruitTransactionValidator.isValid(fruitTransaction)) {
            throw new InvalidFruitTransactionException(
                    "Invalid FruitTransaction: " + fruitTransaction
            );
        }
        fruitTransactionDao.add(fruitTransaction);
    }

    @Override
    public void registerAllTransactions(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(this::registerSingleTransaction);
    }

    @Override
    public FruitTransactionReport generateReport() {
        Function<FruitTransaction, Integer> operationHandlerFunction = fruitTransaction ->
                fruitTransactionOperationStrategy
                        .getHandler(fruitTransaction.getOperation())
                        .handle(fruitTransaction.getQuantity());

        Map<String, Integer> reportMap = fruitTransactionDao.getAll().stream()
                .collect(Collectors.groupingBy(
                        FruitTransaction::getFruit,
                        Collectors.mapping(
                                operationHandlerFunction,
                                Collectors.summingInt(value -> value)
                        )
                ));

        List<FruitTransactionReport.Entry> entries = reportMap.entrySet().stream()
                .map(stringIntegerEntry ->
                        new FruitTransactionReport.Entry(
                                stringIntegerEntry.getKey(), stringIntegerEntry.getValue()
                        )
                )
                .collect(Collectors.toList());

        return new FruitTransactionReport(entries);
    }
}
