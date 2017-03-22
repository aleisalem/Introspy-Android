package com.introspy.custom_hooks;

import com.introspy.core.IntroHook;

class HookContentResolver extends IntroHook {
	String getNotes(){
		return _notes;
	}
}

class Intro_ContentResolver_delete extends HookContentResolver{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("uri", args[0].toString());
		_logParameter("selection", args[1]);
		_logParameter("selectionArgs", args[2]);
		_logFlush_I("android.content.ContentProvider.delete(" + args[0] + ", " + args[1] + ", args)");
	}
}

class Intro_ContentResolver_insert extends HookContentResolver{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("uri", args[0].toString());
		_logParameter("values", args[1]);
		_logFlush_I("android.content.ContentProvider.insert(" + args[0].toString() + ", " + args[1] + ")");
	}
}

class Intro_ContentResolver_openFileDescriptor extends HookContentResolver{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("uri", args[0].toString());
		_logParameter("mode", args[1]);
		_logFlush_I("android.content.ContentProvider.onStartCommand(" + args[0].toString() + ", " + args[1] + ")");
	}
}

class Intro_ContentResolver_query extends HookContentResolver{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("uri", args[0].toString());
		_logParameter("projection", args[1]);
		_logParameter("selection", args[2]);
		_logParameter("selectionArgs", args[3]);
		_logParameter("sortOrder", args[4]);
		_logFlush_I("android.content.ContentProvider.query(" + args[0].toString() + ")");
	}
}

class Intro_ContentResolver_update extends HookContentResolver{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();	
		_logParameter("uri", args[0].toString());
		_logParameter("values", args[1]);
		_logParameter("selection", args[2]);
		_logParameter("selectionArgs", args[3]);
		_logFlush_I("android.content.ContentProvider.update(" + args[0].toString() + ")");
	}
}