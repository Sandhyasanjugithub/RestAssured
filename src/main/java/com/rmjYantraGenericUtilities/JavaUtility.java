package com.rmjYantraGenericUtilities;

import java.util.Random;

public class JavaUtility {
	public static int getRandomNumber()
	{
		Random r =new Random();
		int ran = r.nextInt(1000);
		return ran;
	}
}
