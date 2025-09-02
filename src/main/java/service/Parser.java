package service;

public interface Parser<T> {
    T parse(String transaction);
}
