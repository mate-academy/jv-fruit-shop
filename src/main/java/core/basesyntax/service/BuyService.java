package core.basesyntax.service;

import core.basesyntax.products.Fruit;
import core.basesyntax.storage.ListStorage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuyService implements Handleable {

    @Override
    public void operationWithProduct(Fruit fruit) {
        int numNeededFruit = fruit.getAmount();
        String fruitName = fruit.getName();
        Optional<Fruit> optionalFruit = buyProduct(fruit);
        optionalFruit.ifPresent(x -> x.setAmount(x.getAmount() - fruit.getAmount()));

    }
    private Optional<Fruit> buyProduct(Fruit fruit) {
    return ListStorage.listStorage.stream()
            .filter(x -> x.getName().equals(fruit.getName()))
            .filter(x -> x.getDate().isAfter(fruit.getDate()))
            .filter(x -> x.getAmount() >= fruit.getAmount())
            .min(Comparator.comparing(Fruit::getDate));

    }
}
