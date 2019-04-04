
@FunctionalInterface
public interface ThreeFunction<T,U,S, R> {

    R apply(T t, U u, S s);
}
