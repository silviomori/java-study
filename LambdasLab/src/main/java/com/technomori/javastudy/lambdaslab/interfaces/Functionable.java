package com.technomori.javastudy.lambdaslab.interfaces;

@FunctionalInterface
public interface Functionable<T, R> {
	R applyThis(T t);
}
