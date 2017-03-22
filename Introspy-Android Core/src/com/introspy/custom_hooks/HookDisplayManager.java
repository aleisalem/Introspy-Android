package com.introspy.custom_hooks;

import com.introspy.core.IntroHook;

class HookDisplayManager extends IntroHook {
	String getNotes(){
		return _notes;
	}
}

class Intro_DisplayManager_getDisplay extends HookDisplayManager{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		_logParameter("displayId", args[0]);
		_logFlush_I("android.hardware.display.getDisplay()");
	}
}

class Intro_DisplayManager_getDisplays extends HookDisplayManager{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		_logFlush_I("android.hardware.display.getDisplays()");
	}
}
