package core.basesyntax.service;

import java.util.Map;

public interface CreateReport {
    Map<String, Integer> countBalanceOfFruits(
            String fruit, int balance, int supply, int purches, int reture);
}
