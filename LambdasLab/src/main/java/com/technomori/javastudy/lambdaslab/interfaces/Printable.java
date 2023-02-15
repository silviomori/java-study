package com.technomori.javastudy.lambdaslab.interfaces;

@FunctionalInterface
public interface Printable<T> {
	void print(T t);
}
