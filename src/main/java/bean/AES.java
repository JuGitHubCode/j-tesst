package bean;

import java.io.UnsupportedEncodingException;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

public class AES {
	
	String iv;
	Key keyspec;
	final static String key="1234567890123456";
	
	
	public AES() {
		
		try {
			iv =key.substring(0,16);
			byte[] keyBytes=new byte[16];
			byte[] b = key.getBytes("utf-8");
			int len =b.length;
			if(len>keyBytes.length)len=keyBytes.length;
			System.arraycopy(b, 0, keyBytes, 0, len);
			SecretKeySpec spec=new SecretKeySpec(keyBytes, "AES");
			this.keyspec=keyspec;
			
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}		
	}
	
	public String enc(String str) {
		String encStr="";
		
		try {
			Cipher c=Cipher.getInstance("AES/CBS/PKCS5Padding");
			c.init(Cipher.ENCRYPT_MODE,keyspec,new IvParameterSpec(iv.getBytes()));
			byte[] encrypted=c.doFinal(str.getBytes("utf-8"));
			encStr=new String(Base64.encodeBase64(encrypted));
		}catch (Exception e) {
			
		}
		return encStr;
	}

	
	
	public String dec(String str) {
		String decStr="";
		try {
			Cipher c=Cipher.getInstance("AES/CBS/PKCS5Padding");
			c.init(Cipher.DECRYPT_MODE,keyspec,new IvParameterSpec(iv.getBytes()));
			byte[] byteStr=Base64.decodeBase64(str.getBytes());
			decStr=new String(c.doFinal(byteStr),"utf-8");
		}catch (Exception e) {
		}
		return decStr;
	}
	
	public static void main(String[] args) {
		AES aes = new AES();
		String msg = "it여행자";
		String rMsg = aes.enc(msg);
		System.out.println(msg);
		System.out.println(rMsg);
		String decStr = aes.dec(rMsg);
		System.out.println(decStr);
	}

}
