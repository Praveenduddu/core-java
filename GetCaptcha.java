package de.zeroco.javabean;

public class GetCaptcha {
	final static String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	final static String ALLCASING = ALPHABETS + ALPHABETS.toLowerCase();
	final static String NUMBERS = "1234567890";
	static int randomNum;

	public static void main(String[] args) {

		System.out.println(GetCaptcha.getCaptcha());
		System.out.println(GetCaptcha.getCaptcha(6));
		System.out.println(GetCaptcha.getalphaNumCaptcha(7, "alphanumeric"));
	}

	public static String getCaptcha() {
		return GetCaptcha.getCaptcha(5);
	}

	public static String getCaptcha(int size) {
		String captcha = "";
		int count = 1;
		while (count <= size) {
			randomNum = (int) (Math.random() * ALLCASING.length() - 1);
			captcha = captcha + ALLCASING.charAt(randomNum);
			count++;
		}
		return captcha;
	}

	public static String getalphaNumCaptcha(int size, String type) {
		String captcha = "";
		int count = 1;
		if ("alphanumeric" == type) {
			while (count <= size) {
				String numAlpha = ALLCASING + NUMBERS;
				randomNum = (int) (Math.random() * numAlpha.length() - 1);
				captcha = captcha + numAlpha.charAt(randomNum);
				count++;
			}
		} else {
			getCaptcha(size);
		}
		return captcha;
	}

}
