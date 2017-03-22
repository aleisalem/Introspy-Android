package com.introspy.custom_hooks;

import com.introspy.core.IntroHook;

class HookClass extends IntroHook {
	String getNotes(){
		return _notes;
	}
}

class Intro_Class_forName extends HookClass{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("name", args[0]);
		_logParameter("initialize", args[1].toString());
		_logFlush_I("java.lang.class.forName(" + args[0] + ", " + args[1].toString() + ")");
	}
}

class Intro_Class_forName2 extends HookClass{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("className", args[0]);
		_logFlush_I("java.lang.class.forName(" + args[0] + ")");
	}
}

class Intro_Class_getClassLoader extends HookClass{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("java.lang.class.getClassLoader()");
	}
}

class Intro_Class_getClasses extends HookClass{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("java.lang.class.getClasses()");
	}
}

class Intro_Class_getField extends HookClass{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("name", args[0]);
		_logFlush_I("java.lang.class.getField(" + args[0] + ")");
	}
}

class Intro_Class_getFields extends HookClass{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("java.lang.class.getFields()");
	}
}

class Intro_Class_getMethods extends HookClass{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("java.lang.class.getMethods()");
	}
}

class Intro_Class_getName extends HookClass{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("java.lang.class.getName()");
	}
}
