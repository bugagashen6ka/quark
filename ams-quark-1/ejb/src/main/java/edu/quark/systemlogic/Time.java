package edu.quark.systemlogic;

import java.util.Date;

import edu.quark.datatypes.TimeInfo;
import edu.quark.systeminterfaces.ITime;

public class Time implements ITime {

	@Override
	public TimeInfo createTimeInformation(Date start, Date end) {
		// TODO Auto-generated method stub
		return new TimeInfo(start, end);
	}

}
