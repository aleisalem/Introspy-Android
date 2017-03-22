package com.introspy.custom_hooks;

import com.introspy.core.IntroHook;

class HookURL extends IntroHook {
	String getNotes(){
		return _notes;
	}
}

class Intro_URL_openConnection extends HookURL{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("java.net.URL.openConnection()");
	}
}

class Intro_URL_openStream extends HookURL{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		_logFlush_I("android.net.URL.openStream()");
	}
}