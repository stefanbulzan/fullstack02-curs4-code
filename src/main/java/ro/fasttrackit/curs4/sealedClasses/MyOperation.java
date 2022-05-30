package ro.fasttrackit.curs4.sealedClasses;

import java.util.Optional;
import java.util.function.Supplier;

public interface MyOperation<T> {

    default T findOrCreate(String id, Supplier<T> creator) {
        return findById(id)
                .orElseGet(() -> this.save(creator.get()));
    }

    T save(T entity);

    Optional<T> findById(String id);

    default T run() {
        if (validate()) {
            return execute();
        } else {
            extracted();
            return null;
        }
    }

    private void extracted() {
        System.out.println("jjfkdlsa");
    }

    T execute();

    boolean validate();

    default int getOrder() {
        return 0;
    }
}
