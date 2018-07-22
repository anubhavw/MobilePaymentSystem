package com.del.service;

import com.del.exception.MobileException;

public interface MobileService {

	void depositAmount(double amount,String mode) throws MobileException;

	double getBalance();

	boolean authenticate(String login, String password);

}
