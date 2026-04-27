package com.backend.testing;

public class A1 {

	public A1 a() {
		System.out.println("execute a mtd");
		return new A1();
	}

	public A1 b() {
		System.out.println("execute b mtd");
		return new A1();
	}

	public B c() {
		System.out.println("execute c mtd");
		return new B();
	}
}
