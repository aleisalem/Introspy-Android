package com.introspy.custom_hooks;

import com.introspy.core.IntroHook;

class HookPowerManager extends IntroHook {
	String getNotes(){
		return _notes;
	}
}

class Intro_PowerManager_isInteractive extends HookPowerManager{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("android.os.PowerManager.isInteractive()");
	}
}

class Intro_PowerManager_isScreenOn extends HookPowerManager{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("android.os.PowerManager.isScreenOn()");
	}
}

class Intro_PowerManager_reboot extends HookPowerManager{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("reason", args[0]);
		_logFlush_I("android.os.PowerManager.reboot(" + args[0] + ")");
	}
}
