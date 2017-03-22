package com.introspy.custom_hooks;

import com.introspy.core.IntroHook;

class HookMediaRecorder extends IntroHook {
	String getNotes(){
		return _notes;
	}
}

class Intro_MediaRecorder_prepare extends HookMediaRecorder{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("android.media.MediaRecorder.prepare()");
	}
}

class Intro_MediaRecorder_setCamera extends HookMediaRecorder{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("android.media.MediaRecorder.setCamera()");
	}
}

class Intro_MediaRecorder_start extends HookMediaRecorder{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("android.media.MediaRecorder.start()");
	}
}

class Intro_MediaRecorder_stop extends HookMediaRecorder{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("android.media.MediaRecorder.stop()");
	}
}