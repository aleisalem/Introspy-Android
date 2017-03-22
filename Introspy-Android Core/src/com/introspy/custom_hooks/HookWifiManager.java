package com.introspy.custom_hooks;

import com.introspy.core.IntroHook;

class HookWifiManager extends IntroHook {
	String getNotes(){
		return _notes;
	}
}

class Intro_WifiManager_disconnect extends HookWifiManager{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("android.net.wifi.WifiManager.disconnect()");
	}
}

class Intro_WifiManager_getScanResults extends HookWifiManager{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("android.net.wifi.WifiManager.getScanResults()");
	}
}

class Intro_WifiManager_getWifiState extends HookWifiManager{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("android.net.wifi.WifiManager.getWifiState()");
	}
}

class Intro_WifiManager_reconnect extends HookWifiManager{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("android.net.wifi.WifiManager.reconnect()");
	}
}

class Intro_WifiManager_startScan extends HookWifiManager{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("android.net.wifi.WifiManager.startScan()");
	}
}