package core.basesyntax.service;

import java.util.Map;

public interface Distributor {
    void distribute(Map<String,Integer> map, String[] note);
}
