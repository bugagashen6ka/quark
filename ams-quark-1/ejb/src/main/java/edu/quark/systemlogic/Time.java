package edu.quark.systemlogic;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import edu.quark.datatypes.TimeInfo;
import edu.quark.systeminterfaces.ITime;

@Stateless
@LocalBean
public class Time implements ITime {

	@Override
	public TimeInfo createTimeInformation(Date start, Date end) {
		if (start.after(end)) {
			return null;
		}

		return new TimeInfo(start, end);
	}

}
