package com.del.dao;

import com.del.exception.MobileException;

public interface MobileDao {

	void depositAmount(double amount,String mode);

	double getBalance();

	boolean authenticate(String login, String password);

}
