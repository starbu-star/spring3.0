package com.exe.springdi4;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTimeService implements TimeService{

	public String getTimeString() {
		
		/**캘린더 말고 이런 클래스도 있다*/
		SimpleDateFormat sdf =
				(SimpleDateFormat)
				SimpleDateFormat.getDateTimeInstance(SimpleDateFormat.LONG, SimpleDateFormat.LONG);//형식 맞추기 
		String now = sdf.format(new Date());
		
		return now;
	}

}
