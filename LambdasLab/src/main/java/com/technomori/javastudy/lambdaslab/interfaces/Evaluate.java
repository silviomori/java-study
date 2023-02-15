package com.technomori.javastudy.lambdaslab.interfaces;

@FunctionalInterface
public interface Evaluate<T> {
	boolean isNegative(T t);
}
