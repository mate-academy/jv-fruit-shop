package core.basesyntax.validator;

import java.util.List;
import java.util.stream.Collectors;

public class ValidatorImpl implements Validator {

    @Override
    public boolean validate(List<String> input) {
        input.remove(0);
        List<String> fruits = input.stream().map(s -> s.split(","))
                .filter(strings -> strings[0].equals("b"))
                .map(strings -> strings[1])
                .collect(Collectors.toList());
        return !input.stream()
                .map(s -> s.split(","))
                .anyMatch(strings -> Integer.parseInt(strings[2]) < 0
                    || (strings[0].isEmpty() || strings[1].isEmpty() || strings[2].isEmpty())
                    || !(strings[0].equals("s")
                        || strings[0].equals("b")
                        || strings[0].equals("p")
                        || strings[0].equals("r"))
                    || !(fruits.contains(strings[1])));
    }
}
