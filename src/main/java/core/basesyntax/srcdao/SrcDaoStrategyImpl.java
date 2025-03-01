package core.basesyntax.srcdao;

import java.util.HashMap;
import java.util.Map;

public class SrcDaoStrategyImpl implements SrcDaoStrategy {
    private final Map<SrcTypes, SrcDao> srcDaoMap;

    public SrcDaoStrategyImpl() {
        srcDaoMap = new HashMap<>();
        srcDaoMap.put(SrcTypes.FILE, new FileSrcDao());
        srcDaoMap.put(SrcTypes.DB, null);
        srcDaoMap.put(SrcTypes.CLOUD, null);
    }

    @Override
    public SrcDao getSrcDao(SrcTypes type) {
        return srcDaoMap.get(type);
    }
}
