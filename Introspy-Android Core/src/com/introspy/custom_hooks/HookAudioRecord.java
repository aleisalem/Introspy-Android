package com.introspy.custom_hooks;

import com.introspy.core.IntroHook;

class HookAudioRecord extends IntroHook {
	String getNotes(){
		return _notes;
	}
}

class Intro_AudioRecord_read extends HookAudioRecord{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		short[] audioData = (short[]) args[2];
		String aArgs = "";
		for (int i = 0; i < audioData.length; i++)
			aArgs = aArgs + (char) audioData[i] + ",";
		_logParameter("audioData", aArgs);
		_logParameter("offsetInShorts", args[1]);
		_logParameter("sizeInShorts", args[2]);
		_logFlush_I("android.media.AudioRecord.read(" + aArgs + ")");
	}
}

class Intro_AudioRecord_read2 extends HookAudioRecord{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("audioBuffer", args[0].toString());
		_logParameter("sizeInBytes", args[1]);
		_logFlush_I("android.media.AudioRecord.read(" + args[0].toString() + ")");
	}
}

class Intro_AudioRecord_read3 extends HookAudioRecord{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("android.media.AudioRecord.read()");
	}
}

class Intro_AudioRecord_startRecording extends HookAudioRecord{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("android.media.AudioRecord.startRecording()");
	}
}

class Intro_AudioRecord_stop extends HookAudioRecord{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("android.media.AudioRecord.stop()");
	}
}