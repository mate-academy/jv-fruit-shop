package core.basesyntax.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculatorImpl implements Calculator {
    private static final Distributor DISTRIBUTOR = new DistributorImpl();

    @Override
    public Map<String,Integer> calculate(List<String[]> notes) {
        Map<String, Integer> result = new HashMap<>();
        for (String[] note : notes) {
            DISTRIBUTOR.distribute(result, note);
        }
        return result;
    }
}
