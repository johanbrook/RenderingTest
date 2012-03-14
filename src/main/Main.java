package main;

import core.ViewController;
import gui.*;

public class Main {

	public static void main(String[] args) {
		if (args[0].equals("m1")) {
			System.out.println("Method 1");
			new ViewController(new RendererV1());
		} else if (args[0].equals("m2")) {
			System.out.println("Method 2");
		} if (args[0].equals("m3")) {
			System.out.println("Method 3");
		}
	}
	
}
