package com.introspy.custom_hooks;

import com.introspy.core.IntroHook;

import android.accounts.Account;

class HookAccountManager extends IntroHook {
	String getNotes(){
		return _notes;
	}
}

class Intro_AccountManager_clearPassword extends HookAccountManager{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		Account acc = (Account) args[0];
		_logParameter("account", acc.name + ":" + acc.type);
		_logFlush_I("android.accounts.AccountManager.clearPassword: " + acc.name);
	}
}

class Intro_AccountManager_getAccounts extends HookAccountManager{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		_logFlush_I("android.accounts.AccountManager.getAccounts");
	}
}

class Intro_AccountManager_getPassword extends HookAccountManager{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		Account acc = (Account) args[0];
		_logParameter("account", acc.name + ":" + acc.type);
		_logFlush_I("android.accounts.AccountManager.getPassword: " + acc.name);
	}
}

class Intro_AccountManager_peekAuthToken extends HookAccountManager{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		Account acc = (Account) args[0];
		_logParameter("account", acc.name + ":" + acc.type);
		_logParameter("authTokenType", args[1]);
		_logFlush_I("android.accounts.AccountManager.peekAuthToken(" + acc.name + ", " + args[1] + ")");
	}
}

class Intro_AccountManager_setAuthToken extends HookAccountManager{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		Account acc = (Account) args[0];
		_logParameter("account", acc.name + ":" + acc.type);
		_logParameter("authTokenType", args[1]);
		_logParameter("authToken", args[2]);
		_logFlush_I("android.accounts.AccountManager.setAuthToken(" + acc.name + ", " + args[1] + ", " + args[2] + ")");
	}
}

class Intro_AccountManager_setPassword extends HookAccountManager{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		Account acc = (Account) args[0];
		_logParameter("account", acc.name + ":" + acc.type);
		_logParameter("password", args[1]);
		_logFlush_I("android.accounts.AccountManager.setPassword(" + acc.name + ", " + args[1] + ")");
	}
}
