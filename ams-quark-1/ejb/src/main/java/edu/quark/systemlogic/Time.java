package edu.quark.systemlogic;

import java.util.Date;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;

import edu.quark.datatypes.TimeInfo;
import edu.quark.systeminterfaces.ITime;

@Stateless
@LocalBean
public class Time implements ITime {

	@Override
	public TimeInfo createTimeInformation(Date start, Date end) {
		// TODO Auto-generated method stub
		return new TimeInfo(start, end);
	}

}
