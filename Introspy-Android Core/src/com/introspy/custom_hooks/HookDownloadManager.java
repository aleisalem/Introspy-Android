package com.introspy.custom_hooks;

import com.introspy.core.IntroHook;

import android.app.DownloadManager.Request;
import android.app.DownloadManager.Query;
import java.net.URI;

class HookDownloadManager extends IntroHook {
	String getNotes(){
		return _notes;
	}
}

class Intro_DownloadManager_addCompletedDownload extends HookDownloadManager{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("title", args[0].toString());
		_logParameter("description", args[1].toString());
		_logParameter("mediascannerscannable", args[2]);
		_logParameter("mimetype", args[3].toString());
		_logParameter("path", args[4].toString());
		_logParameter("length", args[5]);
		_logParameter("shownotification", args[6]);
		_logFlush_I("android.app.DownloadManager.addCompletedDownload(" + args[0].toString() + ", " + args[1].toString() + ",...)" );
	}
}

class Intro_DownloadManager_enqueue extends HookDownloadManager{
	@Override
	public void execute(Object... args){
		_logBasicInfo();	
		_logFlush_I("android.app.DownloadManager.enqueue()");
	}
}

class Intro_DownloadManager_getURIForDownloadedFile extends HookDownloadManager{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		_logParameter("id", args[0]);
		_logFlush_I("android.app.DownloadManager.getUriForDownloadedFile(" + args[0] + ")");
	}	
}

class Intro_DownloadManager_openDownloadedFile extends HookDownloadManager{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		_logParameter("id", args[0]);
		_logFlush_I("android.app.DownloadManager.openDownloadedFile(" + args[0] + ")");
	}	
}

class Intro_DownloadManager_query extends HookDownloadManager{
	@Override
	public void execute(Object... args){
		_logBasicInfo();
		_logFlush_I("android.app.DownloadManager.query()");
	}	
}