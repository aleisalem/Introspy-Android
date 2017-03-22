package com.introspy.custom_hooks;

import com.introspy.core.IntroHook;

class HookLocation extends IntroHook {
	String getNotes(){
		return _notes;
	}
}

class Intro_Location_getLatitude extends HookLocation{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("android.location.open()");
	}
}

class Intro_Location_getLongitude extends HookLocation{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		_logFlush_I("android.location.reconnect()");
	}
}
