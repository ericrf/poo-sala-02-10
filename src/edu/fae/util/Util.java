package edu.fae.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {

	public static String gerarMD5(String texto) {
		String sen = "";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		BigInteger hash = new BigInteger(1, md.digest(texto.getBytes()));
		sen = hash.toString(16);
		return sen;
	}
	
	public static void main(String args[]) {
		System.out.println(gerarMD5("xxjjfoekjdijfakjefajsdfkjsadfd"));
	}
}
