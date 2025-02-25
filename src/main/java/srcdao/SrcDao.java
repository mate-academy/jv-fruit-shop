package srcdao;

import java.util.List;

public interface SrcDao {

    boolean openSrc(String uri);

    boolean closeSrc(String uri);

    boolean readSrc();

    List<String> getSrcContents();
}
