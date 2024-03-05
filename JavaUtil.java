package CommonUtil;

import java.util.Random;

public class JavaUtil
{

	public int getRandomNumber()
	{
		Random r=new Random();
		int i = r.nextInt(500);
		return i;

	}

}
