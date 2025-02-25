package dstdao;

import java.util.HashMap;
import java.util.Map;

public class DstDaoStrategyImpl implements DstDaoStrategy {
    private final Map<DstTypes, DstDao> dstDaoMap;

    public DstDaoStrategyImpl() {
        dstDaoMap = new HashMap<>();
        dstDaoMap.put(DstTypes.FILE, new FileDstDao());
        dstDaoMap.put(DstTypes.DB, null);
        dstDaoMap.put(DstTypes.CLOUD, null);
    }

    @Override
    public DstDao getDstDao(DstTypes type) {
        return dstDaoMap.get(type);
    }
}
