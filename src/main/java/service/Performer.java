package service;

import java.util.List;

public interface Performer<T> {
    void performProcess(T process);

    boolean performProcesses(List<T> processes);
}
