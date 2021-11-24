package service;

import java.util.List;

public interface Parser<T> {
    List<T> parseLines(List<String> line);
}
