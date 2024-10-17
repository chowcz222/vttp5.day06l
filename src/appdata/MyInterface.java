package appdata;

@FunctionalInterface
public interface MyInterface<T> {
    T process (T a, T b);
    
}
