package core.basesyntax;

import core.basesyntax.model.Fruit;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Storage {
    private final List<Fruit> fruits = new ArrayList<>();

    public void add(Fruit fruit) {
        checkNull(fruit);
        Optional<Fruit> optionalFruit = fruits.stream()
                .filter(x -> x.getName().equals(fruit.getName()))
                .findFirst();
        optionalFruit.ifPresentOrElse(x -> x.setQuantity(x.getQuantity()
                + fruit.getQuantity()), () -> fruits.add(fruit.clone()));
    }

    public void remove(Fruit fruit) {
        checkNull(fruit);
        Optional<Fruit> optionalFruit = fruits.stream()
                .filter(x -> x.getName().equals(fruit.getName()))
                .filter(x -> x.getQuantity() >= fruit.getQuantity())
                .findFirst();
        optionalFruit.ifPresentOrElse(x -> x.setQuantity(x.getQuantity() - fruit.getQuantity()),
                () -> {
                    throw new InvalidParameterException("Wrong amount of fruit "
                            + fruit.getQuantity());
                });
    }

    public Fruit getByName(String name) {
        Optional<Fruit> optionalFruit = fruits.stream()
                .filter(x -> x.getName().equals(name))
                .findFirst();
        return optionalFruit.orElseThrow(NoSuchElementException::new);
    }

    public List<Fruit> getAll() {
        return fruits;
    }

    public int size() {
        return fruits.size();
    }

    public void clear() {
        fruits.clear();
    }

    private void checkNull(Fruit fruit) {
        if (fruit == null) {
            throw new NullPointerException();
        }
    }
}
