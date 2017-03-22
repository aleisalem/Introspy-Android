package com.introspy.custom_hooks;

import com.introspy.core.IntroHook;

import android.content.Intent;

class HookIntentService extends IntroHook {
	String getNotes(){
		return _notes;
	}
}

class Intro_IntentService_onStartCommand extends HookIntentService{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("intent", (Intent)args[0]);
		_logParameter("flags", args[1]);
		_logParameter("startId", args[2]);
		_logFlush_I("android.app.IntentService.onStartCommand(" + (Intent)args[0] + ", " + args[1] + ", " + args[2] + ")");
	}
}