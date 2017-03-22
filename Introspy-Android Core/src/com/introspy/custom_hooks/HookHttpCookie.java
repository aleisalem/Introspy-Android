package com.introspy.custom_hooks;

import com.introspy.core.IntroHook;

class HookHttpCookie extends IntroHook {
	String getNotes(){
		return _notes;
	}
}

class Intro_HttpCookie_getName extends HookHttpCookie{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("java.net.HttpCookie.getName()");
	}
}

class Intro_HttpCookie_getPath extends HookHttpCookie{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("java.net.HttpCookie.getPath()");
	}
}

class Intro_HttpCookie_getSecure extends HookHttpCookie{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("java.net.HttpCookie.getSecure()");
	}
}

class Intro_HttpCookie_getValue extends HookHttpCookie{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("java.net.HttpCookie.getValue()");
	}
}

class Intro_HttpCookie_parse extends HookHttpCookie{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("header", args[0]);
		_logFlush_I("java.net.HttpCookie.parse(" + args[0] + ")");
	}
}

class Intro_HttpCookie_setPath extends HookHttpCookie{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("uri", args[0]);
		_logFlush_I("java.net.HttpCookie.setPath(" + args[0] + ")");
	}
}

class Intro_HttpCookie_setSecure extends HookHttpCookie{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("flag", args[0].toString());
		_logFlush_I("java.net.HttpCookie.setSecure(" + args[0].toString() + ")");
	}
}

class Intro_HttpCookie_setValue extends HookHttpCookie{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("newValue", args[0]);
		_logFlush_I("java.net.HttpCookie.setValue(" + args[0] + ")");
	}
}
