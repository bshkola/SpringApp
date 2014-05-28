package pw.bshkola.security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("saltPasswordEncoder")
public class SaltPasswordEncoder implements PasswordEncoder {

	public static String generateHash(String plainText) throws NoSuchAlgorithmException {
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.reset();
		m.update(plainText.getBytes());
		
		byte[] digest = m.digest();
		BigInteger bigInt = new BigInteger(1,digest);
		String hashtext = bigInt.toString(16);
		while(hashtext.length() < 32 ){
		  hashtext = "0" + hashtext;
		}
		
		return hashtext;
	}

	public String encode(CharSequence rawPassword) {
		String salt = "abc";
		String encPass = "";
		
		try {
			encPass = generateHash(rawPassword + salt);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encPass;
	}

	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		String salt = "abc";
		String encPass = "";
		
		try {
			encPass = generateHash(rawPassword + salt);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encPass.equals(encodedPassword);
	}
	
}
