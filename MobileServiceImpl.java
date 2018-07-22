package com.del.service;

import com.del.dao.MobileDao;
import com.del.dao.MobileImpl;
import com.del.exception.MobileException;
import com.del.util.Message;

public class MobileServiceImpl implements MobileService {
	private MobileDao mDao;
	
	public MobileServiceImpl() {
		mDao = new MobileDaoImpl();
	}
	@Override
	public void depositAmount(double amount,String mode) 
			throws MobileException {
		isAmountNegative(amount);
		mDao.depositAmount(amount,mode);
	}
	@Override
	public double getBalance() {
		return mDao.getBalance();
	}
	}
	private boolean isAmountNegative(double amount)
			     throws MobileException {
		if(amount<0) {
			throw new MobileException(Message.NEGATIVE_VALUE);
		}
		return true;
	}
	@Override
	public boolean authenticate(String login, String password) {
		return mDao.authenticate(login,password);
	}

}
