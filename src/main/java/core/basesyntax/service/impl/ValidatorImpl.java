package core.basesyntax.service.impl;

import core.basesyntax.service.Validator;

public class ValidatorImpl implements Validator {

    @Override
    public boolean validate(String line) {
        String[] oneLineData = line.split(",");
        if (oneLineData[0].matches("[bspr]")
                && !oneLineData[1].isEmpty()
                && !oneLineData[2].isEmpty()
                && Integer.parseInt(oneLineData[2]) > 0
                && oneLineData.length == 3) {
            return true;
        }
        return false;
    }
}
