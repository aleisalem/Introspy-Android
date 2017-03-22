package com.introspy.custom_hooks;

import android.content.Intent;
import android.os.Bundle;

import com.introspy.core.IntroHook;

class HookActivities extends IntroHook {
	String getNotes(){
		return _notes;
	}
	
	protected String getExtras(Intent intent) {
		String out = "";
		try {
			Bundle bundle = intent.getExtras();
		    if (bundle != null) {
				for (String key : bundle.keySet()) {
				    Object value = bundle.get(key);
				    out += String.format("--> [%s %s (%s)]\n", key,  
				        value.toString(), value.getClass().getName());
				}
				out = out.substring(0, out.length() - 1);
		    }
		}
		catch (Exception e) {
			out = "Cannot get intent extra";
		}
		return out;
	}

}

class Intro_Activity_startActivity extends HookActivities{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		// arg0 is an Intent
		Intent intent = (Intent) args[0];
		String out = "-> " + intent;
		_logParameter("Intent", intent);
		String extra = getExtras(intent);
		if (!extra.isEmpty()) {
			_logParameter("Extra", extra);
			out += "\n-> Extra: \n" + extra + "";
		}
		_logFlush_I(out);
		////_logFlush_I("Starting activity: " + getNotes());
	}
}

class Intro_Activity_setContentView extends HookActivities{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		_logFlush_I("android.app.Activity.setContentView()");
	}
}

class Intro_Activity_setVisible extends HookActivities{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		_logParameter("boolean", args[0]);
		_logFlush_I("android.app.Activity.setVisible(" + args[0] + ")");
	}
}

class Intro_Activity_takeKeyEvents extends HookActivities{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		_logParameter("boolean", args[0]);
		_logFlush_I("android.app.Activity.takeKeyEvents(" + args[0] + ")");
	}
}