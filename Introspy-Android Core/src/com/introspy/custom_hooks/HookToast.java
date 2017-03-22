package com.introspy.custom_hooks;

import com.introspy.core.IntroHook;

class HookToast extends IntroHook {
	String getNotes(){
		return _notes;
	}
}

class Intro_Toast_makeText extends HookToast{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("duration", args[2]);
		_logFlush_I("android.Toast.makeText(" + args[2] + ")");
	}
}

class Intro_Toast_makeText2 extends HookToast{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("text", args[1].toString());
		_logParameter("duration", args[2]);
		_logFlush_I("android.Toast.makeText(" + args[1].toString() + ", " + args[2] + ")");
	}
}