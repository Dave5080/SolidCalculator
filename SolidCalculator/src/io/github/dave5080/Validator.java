package io.github.dave5080;

public interface Validator<T> {

    boolean isValid(T value);
}
