package sbenkhaoua.appa.tools;

import java.util.Random;

public class PKeyGenerator {

	public static String get() {
		Integer r = new Random(System.nanoTime()).nextInt(999999999);
		return Integer.toHexString(r).toUpperCase();
	}

}
