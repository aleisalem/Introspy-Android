package com.introspy.custom_hooks;

import com.introspy.core.IntroHook;

class HookCamera extends IntroHook {
	String getNotes(){
		return _notes;
	}
}

class Intro_Camera_open extends HookCamera{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("android.hardware.open()");
	}
}

class Intro_Camera_reconnect extends HookCamera{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		_logFlush_I("android.hardware.reconnect()");
	}
}

class Intro_Camera_release extends HookCamera{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		_logFlush_I("android.hardware.release()");
	}
}

class Intro_Camera_startPreview extends HookCamera{
	@Override
	public void execute(Object... args){
		_logBasicInfo();		
		_logFlush_I("android.hardware.startPreview()");
	}
}

class Intro_Camera_stopPreview extends HookCamera{
	@Override
	public void execute(Object... args){
		_logBasicInfo();		
		_logFlush_I("android.hardware.stopPreview()");
	}
}

class Intro_Camera_takePicture extends HookCamera{
	@Override
	public void execute(Object... args){
		_logBasicInfo();		
		_logFlush_I("android.hardware.takePicture()");
	}
}