package com.introspy.custom_hooks;

import com.introspy.core.IntroHook;

class HookVibrator extends IntroHook {
	String getNotes(){
		return _notes;
	}
}

class Intro_Vibrator_cancel extends HookVibrator{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("cancel: " + getNotes());
	}
}

class Intro_Vibrator_vibrate extends HookVibrator{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("milliseconds", args[0]);
		_logFlush_I("vibrate: " + getNotes());
	}
}

class Intro_Vibrator_vibrate2 extends HookVibrator{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		long[] pattern = (long[]) args[0];
		String mArgs = "";
		for (int i = 0; i < pattern.length; i++)
			mArgs = mArgs + Long.toString(pattern[i]) + ",";
		_logParameter("pattern", args[0]);
		_logParameter("repeat", args[1]);
		_logFlush_I("vibrate: " + getNotes());
	}
}
