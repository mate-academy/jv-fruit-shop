package core.basesyntax.service.impl;

import core.basesyntax.service.Validator;

public class ValidatorImpl implements Validator {
    @Override
    public boolean validate(String line) {
        String[] parametersFromLine = line.split(",");
        String type = parametersFromLine[0].replaceAll(" ", "");
        if (parametersFromLine.length != 3) {
            throw new RuntimeException("Invalid date");
        }
        if (!(type.equals("b")
                || type.equals("s")
                || type.equals("p")
                || type.equals("r"))) {
            throw new RuntimeException("Invalid type of activities");
        }
        if (!parametersFromLine[1].matches("[a-zA-Z]*")) {
            throw new RuntimeException("Invalid name of fruit");
        }
        if (!parametersFromLine[2].matches("[0-9]*")) {
            throw new RuntimeException("Invalid quantity of fruit, should be numbers");
        }
        if (Integer.parseInt(parametersFromLine[2]) < 0) {
            throw new RuntimeException("Invalid quantity of fruit, "
                    + "quantity should be more than zero");
        }
        return true;
    }
}
