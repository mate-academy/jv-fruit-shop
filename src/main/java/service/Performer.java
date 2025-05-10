package service;

import java.util.List;

public interface Performer<T> {

    boolean performProcesses(List<T> processes);
}
