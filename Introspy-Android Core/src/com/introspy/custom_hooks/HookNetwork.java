package com.introspy.custom_hooks;

import com.introspy.core.IntroHook;

class HookNetwork extends IntroHook {
	String getNotes(){
		return _notes;
	}
}

class Intro_Network_bindSocket extends HookNetwork{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("socket", args[0].toString());
		_logFlush_I("android.net.Network.bindSocket(" + args[0].toString() + ")");
	}
}

class Intro_Network_openConnection extends HookNetwork{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		_logParameter("url", args[0].toString());
		_logFlush_I("android.net.Network.openConnection(" + args[0].toString() +")");
	}
}
