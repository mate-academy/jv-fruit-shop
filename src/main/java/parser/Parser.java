package parser;

@FunctionalInterface
public interface Parser<J> {
    void parse(J value);
}
