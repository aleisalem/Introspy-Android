package com.introspy.custom_hooks;

import com.introspy.core.IntroHook;

class HookSmsManager extends IntroHook {
	String getNotes(){
		return _notes;
	}
}

class Intro_SmsManager_sendDataMessage extends HookSmsManager{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		String data = "";
		byte[] dataArgs = (byte[]) args[3];
		for (int i = 0; i < dataArgs.length; i++)
			data = data + Byte.toString(dataArgs[i]);
		
		_logParameter("destinationAddress", args[0]);
		_logParameter("scAddress", args[1]);
		_logParameter("data", data);
		_logFlush_I("android.telephony.SmsManager.sendDataMesage(" + args[0] + ", " + args[1] + ")");
	}
}

class Intro_SmsManager_sendTextMessage extends HookSmsManager{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("destinationAddress", args[0]);
		_logParameter("scAddress", args[1]);
		_logParameter("text", args[2]);
		_logFlush_I("android.telephony.SmsManager.sendTextMesage(" + args[0] + ", " + args[1] + ", " + args[2] + ")");
	}
}
