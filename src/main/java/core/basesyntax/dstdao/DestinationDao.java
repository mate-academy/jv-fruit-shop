package core.basesyntax.dstdao;

import java.util.List;

public interface DestinationDao {
    boolean openDst(String uri);

    boolean closeDst(String uri);

    boolean writeDst(List<String> report);
}
