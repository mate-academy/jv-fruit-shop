package service;

import java.util.List;

public interface Parser<V> {
    List<V> parse(List<String> input);
}
