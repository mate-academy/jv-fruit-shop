package service.impl;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.ParseService;

public class CsvParseServiceImpl implements ParseService {
    @Override
    public List<FruitTransaction> parse(List<String[]> transactions) {
        return transactions.stream()
                .map(wrapper(i -> new FruitTransaction(i[0], i[1], Integer.parseInt(i[2]))))
                .collect(Collectors.toList());
    }

    public static <T, R> Function<T, R> wrapper(CheckedFunction<T, R> checkedFunction) {
        return t -> {
            try {
                return checkedFunction.apply(t);
            } catch (Exception e) {
                throw new RuntimeException("Input data doesn't correspond require format: "
                        + e.getClass());
            }
        };
    }
}
