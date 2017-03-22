package com.introspy.custom_hooks;

import com.introspy.core.IntroHook;

class HookNetworkInfo extends IntroHook {
	String getNotes(){
		return _notes;
	}
}

class Intro_NetworkInfo_isAvailable extends HookNetworkInfo{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("android.net.NetworkInfo.isAvailable()");
	}
}

class Intro_NetworkInfo_isConnected extends HookNetworkInfo{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		_logFlush_I("android.net.NetworkInfo.isConnected()");
	}
}


class Intro_NetworkInfo_isRoaming extends HookNetworkInfo{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		_logFlush_I("android.net.NetworkInfo.isRoaming()");
	}
}