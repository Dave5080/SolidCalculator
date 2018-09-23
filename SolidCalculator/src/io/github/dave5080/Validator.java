package io.github.dave5080;

/**
 * This interface is though to be anonymously implemented in order create
 * time to time a custom {@link T} validator.
 * @param <T>
 */
public interface Validator<T> {

    /**
     * Implementing this method it'll be specified what to do in order to
     * check a {@link T} validity.
     * @param value This is the {@link T} type object to validate
     * @return true if the value is valid, false otherwise.
     */
    boolean isValid(T value);
}
