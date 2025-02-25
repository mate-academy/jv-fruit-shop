package dstdao;

import java.util.List;

public interface DstDao {
    boolean openDst(String uri);

    boolean closeDst(String uri);

    boolean writeDst(List<String> report);
}
