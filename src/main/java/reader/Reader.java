package reader;

import java.util.List;

public interface Reader<J, V> {
    List<J> read(V value);
}
