package core.basesyntax.dstdao;

import java.util.HashMap;
import java.util.Map;

public class DestinationDaoStrategyImpl implements DestinationDaoStrategy {
    private final Map<DestinationTypes, DestinationDao> dstDaoMap;

    public DestinationDaoStrategyImpl() {
        dstDaoMap = new HashMap<>();
        dstDaoMap.put(DestinationTypes.FILE, new FileDestinationDao());
        dstDaoMap.put(DestinationTypes.DB, null);
        dstDaoMap.put(DestinationTypes.CLOUD, null);
    }

    @Override
    public DestinationDao getDstDao(DestinationTypes type) {
        return dstDaoMap.get(type);
    }
}
