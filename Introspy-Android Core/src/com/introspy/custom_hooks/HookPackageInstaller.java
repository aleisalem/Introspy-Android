package com.introspy.custom_hooks;

import com.introspy.core.IntroHook;

class HookPackageInstaller extends IntroHook {
	String getNotes(){
		return _notes;
	}
}

class Intro_PackageInstaller_uninstall extends HookPackageInstaller{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		_logParameter("packageName", args[0]);
		_logFlush_I("android.content.pm.PackageInstaller.uninstall(" + args[0] + ")");
	}
}
