package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReportService {
    public static final String SEPARATE_SYMBOL_FOR_CSV = ",";
    public static final String REPORT_FULL_PATH = "src/main/resources/report.csv";
    public static final String TRANSACTION_FULL_PATH = "src/main/resources/transaction.csv";
    public static final String HEAD_OF_TRANSACTION_TABLE = "type,fruit,quantity";
    private static final String HEAD_OF_REPORT_TABLE = "fruit,quantity";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private List<Transaction> transactionList;

    public ReportService() {

    }

    public ReportService(List<String> transactionList) {
        this.transactionList = stringListToTransactionList(transactionList);
    }

    public List<Transaction> stringListToTransactionList(List<String> transactionListString) {
        return transactionListString.stream()
                .map(s -> s.split(SEPARATE_SYMBOL_FOR_CSV))
                .peek(s -> {
                    for (Operation operation : Operation.values()) {
                        if (s[OPERATION_INDEX].equals(operation.getTransaction())) {
                            s[OPERATION_INDEX] = operation.name();
                        }
                    }
                    for (Fruit fruit : Fruit.values()) {
                        if (s[FRUIT_INDEX].equals(fruit.getFruitName())) {
                            s[FRUIT_INDEX] = fruit.name();
                        }
                    }

                })
                .map(t -> new Transaction(Operation.valueOf(t[OPERATION_INDEX]),
                        Fruit.valueOf(t[FRUIT_INDEX]),
                        Integer.parseInt(t[AMOUNT_INDEX])))
                .collect(Collectors.toList());
    }

    public List<String> createReport() {
        List<String> fruitsListToReport = new ArrayList<>();
        Stream.of(Fruit.values())
                .forEach(f -> fruitsListToReport.add(f.getFruitName()
                        + SEPARATE_SYMBOL_FOR_CSV
                        + totalBalanceByOneProduct(transactionList, f)));
        fruitsListToReport.add(0, HEAD_OF_REPORT_TABLE);
        return fruitsListToReport;
    }

    private int totalBalanceByOneProduct(List<Transaction> transactionsList, Fruit fruit) {
        return transactionsList.stream()
                .filter(t -> t.getFruit().getFruitName().equals(fruit.getFruitName()))
                .mapToInt(t -> t.getAmount() * t.getOperation().getFruitDirection())
                .sum();
    }

    public static List<String> transactionsListToStringList(
            List<Transaction> transactionsList, String headOfTable) {
        List<String> list = transactionsList
                .stream()
                .map(t -> t.getOperation().getTransaction()
                        + SEPARATE_SYMBOL_FOR_CSV
                        + t.getFruit().getFruitName()
                        + SEPARATE_SYMBOL_FOR_CSV
                        + t.getAmount())
                .collect(Collectors.toList());
        list.add(0, headOfTable);
        return list;
    }
}
