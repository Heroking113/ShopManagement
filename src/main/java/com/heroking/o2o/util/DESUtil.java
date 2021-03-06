package com.heroking.o2o.util;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

/**
 * @Author heroking
 * @Date 2019年12月1日 上午11:48:49 类说明 :DES是一种对称加密算法，所谓对称加密算法，即：加密和解密使用的相同的密钥的算法
 */
public class DESUtil {
	private static Key key;
	// 设置密钥key
	private static String KEY_STR = "myKey";
	private static String CHARSETNAME = "UTF-8";
	private static String ALGORITHM = "DES";

	// 静态代码块：用以生成我们的DES实例
	static {
		try {
			// 生成DES算法对象
			KeyGenerator generator = KeyGenerator.getInstance(ALGORITHM);
			// 运用SHA1安全策略
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			// 设置上密钥种子
			secureRandom.setSeed(KEY_STR.getBytes());
			// 初始化基于SHA1的算法对象
			generator.init(secureRandom);
			// 生成密钥对象
			key = generator.generateKey();
			generator = null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取加密后的信息
	 * 
	 * @param str
	 * @return
	 */
	public static String getEncryptString(String str) {
		// 基于base64编码，接受byte[]并转换成String
		Base64.Encoder encoder = Base64.getEncoder();
		try {
			// 按照utf-8编码
			byte[] bytes = str.getBytes(CHARSETNAME);
			// 获取加密对象
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			// 初始化密码信息
			cipher.init(Cipher.ENCRYPT_MODE, key);
			// 加密
			byte[] doFinal = cipher.doFinal(bytes);
			// byte[]to encode好的string并返回
			return encoder.encodeToString(doFinal);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String getDecryptString(String str) {
		// 基于base64编码，接受byte[]并转换成String
		Base64.Decoder decoder = Base64.getDecoder();
		try {
			// 将字符串decode成byte[]
			byte[] bytes = decoder.decode(str);
			// 获取解密对象
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			// 初始化解密信息
			cipher.init(Cipher.DECRYPT_MODE, key);
			// 解密
			byte[] doFinal = cipher.doFinal(bytes);
			// 返回解密之后的信息
			return new String(doFinal, CHARSETNAME);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		// 获取加密后的远程数据库的账号和密码
		System.out.println("加密后的远程数据库的账号和密码为:");
		System.out.println(getEncryptString("work"));
		System.out.println(getEncryptString("Heroking113."));
		// 获取解密后的远程数据库的账号和密码
		System.out.println("解密后的远程数据库的账号和密码为:");
		System.out.println(getDecryptString("zCKAAEaFQUI="));
		System.out.println(getDecryptString("Dbhquehm+bJ+UTCqTNtd0Q=="));
	}
}
