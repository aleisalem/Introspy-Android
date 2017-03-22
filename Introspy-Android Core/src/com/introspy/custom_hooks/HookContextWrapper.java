package com.introspy.custom_hooks;

import com.introspy.core.IntroHook;

import android.content.Intent;

class HookContextWrapper extends IntroHook {
	String getNotes(){
		return _notes;
	}
}

class Intro_ContextWrapper_bindService extends HookContextWrapper{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("service", (Intent)args[0]);
		_logFlush_I("android.content.ContextWrapper.bindService(" + (Intent) args[0] + ")");
	}
}

class Intro_ContextWrapper_deleteDatabase extends HookContextWrapper{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		_logParameter("name", args[0]);
		_logFlush_I("android.content.ContextWrapper.deleteDatabase(" + args[0] + ")");
	}
}

class Intro_ContextWrapper_deleteFile extends HookContextWrapper{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		_logParameter("name", args[0]);		
		_logFlush_I("android.content.ContextWrapper.deleteFile(" + args[0] + ")");
	}
}

class Intro_ContextWrapper_deleteSharedPreferences extends HookContextWrapper{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		_logParameter("name", args[0]);		
		_logFlush_I("android.content.ContextWrapper.deleteSharedPreferences(" + args[0] + ")");
	}
}

class Intro_ContextWrapper_getSystemService extends HookContextWrapper{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		_logParameter("name", args[0]);		
		_logFlush_I("android.content.ContextWrapper.getSystemService(" + args[0] + ")");
	}
}

class Intro_ContextWrapper_openFileInput extends HookContextWrapper{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		_logParameter("name", args[0]);		
		_logFlush_I("openFileInput: " + getNotes());
	}
}

class Intro_ContextWrapper_stopService extends HookContextWrapper{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		_logParameter("name", (Intent)args[0]);
		_logFlush_I("stopService: " + getNotes());
	}
}

class Intro_ContextWrapper_unbindService extends HookContextWrapper{
	@Override
	public void execute(Object... args){
		_logBasicInfo();		
		_logFlush_I("unbindService: " + getNotes());
	}
}

class Intro_ContextWrapper_unregisterReceiver extends HookContextWrapper{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		_logFlush_I("unregisterReceiver: " + getNotes());
	}
}