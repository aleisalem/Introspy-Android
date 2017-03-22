package com.introspy.custom_hooks;

import com.introspy.core.IntroHook;

class HookWifiInfo extends IntroHook {
	String getNotes(){
		return _notes;
	}
}

class Intro_WifiInfo_getMacAddress extends HookWifiInfo{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("android.net.wifi.WifiInfo.getMacAddress()");
	}
}

class Intro_WifiInfo_getSSID extends HookWifiInfo{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		_logFlush_I("android.net.wifi.WifiInfo.getSSID()");
	}
}
