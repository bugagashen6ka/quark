package edu.quark.systeminterfaces;

import java.util.Date;

import edu.quark.datatypes.TimeInfo;

public interface ITime {
	TimeInfo createTimeInformation(Date start, Date end);
}
