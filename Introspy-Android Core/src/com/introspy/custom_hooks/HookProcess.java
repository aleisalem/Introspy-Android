package com.introspy.custom_hooks;

import com.introspy.core.IntroHook;

class HookProcess extends IntroHook {
	String getNotes(){
		return _notes;
	}
}

class Intro_Process_killProcess extends HookProcess{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("pid", args[0]);
		_logFlush_I("android.os.Process.isAvailable(" + args[0] + ")");
	}
}
