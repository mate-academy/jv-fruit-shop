package core.basesyntax;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Validator {

    public static void validateInput(List<String[]> data) {
        validateBalanceOperations(data);
        validateAmounts(data);
    }

    private static void validateBalanceOperations(List<String[]> data) {
        data.stream()
                .collect(Collectors.groupingBy(row -> row[1],
                        Collectors.mapping(Function.identity(), Collectors.toList())))
                .forEach((key, value) -> {
                    long countBalanceOperations = value.stream()
                            .filter(row -> row[0].toUpperCase().equals(OperationSet.B.toString()))
                            .count();
                    if (countBalanceOperations != 1) {
                        throw new InvalidOperationException("More or less than one Balance operation found");
                    }
                });
    }

    private static void validateAmounts(List<String[]> data) {
        data.stream()
                .collect(Collectors.groupingBy(row -> row[1],
                        Collectors.mapping(Function.identity(), Collectors.toList())))
                .forEach((key, value) -> {
                    int supplied = value.stream()
                            .filter(row -> !row[0].toUpperCase().equals(OperationSet.P.toString()))
                            .map(row -> Integer.valueOf(row[2]))
                            .reduce(0, Integer::sum);
                    int purchased = value.stream()
                            .filter(row -> row[0].toUpperCase().equals(OperationSet.P.toString()))
                            .map(row -> Integer.valueOf(row[2]))
                            .reduce(0, Integer::sum);
                    if (supplied < purchased) {
                        throw new InvalidOperationException("Demand is higher than supply");
                    }
                });
    }
}
