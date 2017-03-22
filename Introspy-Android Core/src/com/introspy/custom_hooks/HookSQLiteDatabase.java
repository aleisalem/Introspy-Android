package com.introspy.custom_hooks;

import com.introspy.core.IntroHook;

import java.io.File;

class HookSQLiteDatabase extends IntroHook {
	String getNotes(){
		return _notes;
	}
	
	String getStringArgs(String[] args){
		String csArgs = ""; // Comma-separated args
		for(int i = 0; i < args.length; i++)
			csArgs = csArgs + args[i] + ",";
		
		return csArgs;
	}
}

class Intro_SQLiteDatabase_create extends HookSQLiteDatabase{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logFlush_I("android.database.sqlite.SQLiteDatabase.create()");
	}
}

class Intro_SQLiteDatabase_delete extends HookSQLiteDatabase{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("table", args[0]);
		_logParameter("whereClause", args[1]);
		_logParameter("whereArgs", args[2]);
		_logFlush_I("android.database.sqlite.SQLiteDatabase.delete(" + args[0] + ", " + args[1] + ")");
	}
}

class Intro_SQLiteDatabase_deleteDatabase extends HookSQLiteDatabase{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		File f = (File) args[0];
		_logParameter("file", f.getName());
		_logFlush_I("android.database.sqlite.SQLiteDatabase.deleteDatabase(" + f.getName() + ")");
	}
}

class Intro_SQLiteDatabase_execSQL extends HookSQLiteDatabase{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("sql", args[0]);
		_logFlush_I("android.database.sqlite.SQLiteDatabase.execSQL(" + args[0] + ")");
	}
}

class Intro_SQLiteDatabase_execSQL2 extends HookSQLiteDatabase{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("sql", args[0]);
		_logFlush_I("android.database.sqlite.SQLiteDatabase.execSQL(" + args[0] + ")");
	}
}

class Intro_SQLiteDatabase_insert extends HookSQLiteDatabase{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("table", args[0]);
		_logParameter("nullColumnHack", args[1]);
		_logParameter("values", args[2]);
		//_logFlush_I("android.database.sqlite.SQLiteDatabase.insert(" + args[0] + ", " + args[1] + ", ...)");
	}
}

class Intro_SQLiteDatabase_insertOrThrow extends HookSQLiteDatabase{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();		
		_logParameter("table", args[0]);
		_logParameter("nullColumnHack", args[1]);
		_logParameter("values", args[2]);
		_logFlush_I("android.database.sqlite.SQLiteDatabase.insertOrThrow(" + args[0] + ", " + args[1] + ",...)");
	}
}

class Intro_SQLiteDatabase_openDatabase extends HookSQLiteDatabase{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("path", args[0]);
		_logFlush_I("android.database.sqlite.SQLiteDatabase.openDatabase(" + args[0] + ")");
	}
}

class Intro_SQLiteDatabase_openDatabase2 extends HookSQLiteDatabase{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("path", args[0]);
		_logFlush_I("android.database.sqlite.SQLiteDatabase.openDatabase(" + args[0] + ")");
	}
}

class Intro_SQLiteDatabase_query extends HookSQLiteDatabase{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("table", args[1]);
		_logParameter("columns", args[2]);
		_logParameter("selection", args[3]);
		_logParameter("selectionArgs", args[4]);
		_logParameter("groupBy", args[5]);
		_logParameter("having", args[6]);
		_logParameter("orderBy", args[7]);
		_logParameter("limit", args[8]);		
		//_logFlush_I("android.database.sqlite.SQLiteDatabase.query(" + args[0] + ", " + args[1] + ", " + args[3] + ", "
				//+ args[5] + ", " + args[6] + ", " + args[7] + ", " + args[8] + ")");
	}
}

class Intro_SQLiteDatabase_query2 extends HookSQLiteDatabase{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("table", args[0]);
		_logParameter("columns", args[1]);
		_logParameter("selection", args[2]);
		_logParameter("selectionArgs", args[3]);
		_logParameter("groupBy", args[4]);
		_logParameter("having", args[5]);
		_logParameter("orderBy", args[6]);
		_logParameter("limit", args[7]);		
	//	_logFlush_I("android.database.sqlite.SQLiteDatabase.query(" + args[0] + ", " + args[2] + ", " + args[4] + ", " + ""
	//			+ args[5] + ", " + args[6] + ", " + args[7] + ")");
	}
}

class Intro_SQLiteDatabase_query3 extends HookSQLiteDatabase{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("distinct", args[0]);
		_logParameter("table", args[1]);
		_logParameter("columns", args[2]);
		_logParameter("selection", args[3]);
		_logParameter("selectionArgs", args[4]);
		_logParameter("groupBy", args[5]);
		_logParameter("having", args[6]);
		_logParameter("orderBy", args[7]);
		_logParameter("limit", args[8]);		
	//	_logFlush_I("android.database.sqlite.SQLiteDatabase.query(" + args[0] + ", " + args[1] + ", " + args[3] + ", "
	//			+ args[5] + ", " + args[6] + ", " + args[7] + ", " + args[8] + ")");
	}
}

class Intro_SQLiteDatabase_query4 extends HookSQLiteDatabase{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("table", args[0]);
		_logParameter("columns", args[1]);
		_logParameter("selection", args[2]);
		_logParameter("selectionArgs", args[3]);
		_logParameter("groupBy", args[4]);
		_logParameter("having", args[5]);
		_logParameter("orderBy", args[6]);		
		//_logFlush_I("android.database.sqlite.SQLiteDatabase.query(" + args[0] + ", " + args[2] + ", " + args[4] + ", "
		//		+ args[5] + ", " + args[6] + ")");
	}
}

class Intro_SQLiteDatabase_rawQuery extends HookSQLiteDatabase{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("sql", args[0]);
		_logParameter("selectionArgs", args[1]);		
		_logFlush_I("android.database.sqlite.SQLiteDatabase.rawQuery(" + args[0] + ")");
	}
}

class Intro_SQLiteDatabase_rawQuery2 extends HookSQLiteDatabase{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("sql", args[0]);
		_logParameter("selectionArgs", args[1]);		
		_logFlush_I("android.database.sqlite.SQLiteDatabase.rawQuery(" + args[0] + ")");
	}
}

class Intro_SQLiteDatabase_replace extends HookSQLiteDatabase{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("sql", args[0]);
		_logParameter("nullColumnHack", args[1]);
		_logParameter("initialValues", args[2]);		
		_logFlush_I("android.database.sqlite.SQLiteDatabase.replace(" + args[0] + ")");
	}
}

class Intro_SQLiteDatabase_update extends HookSQLiteDatabase{
	@Override
	public void execute(Object... args) {
		_logBasicInfo();
		_logParameter("table", args[0]);
		_logParameter("values", args[1]);
		_logParameter("whereClause", args[2]);
		_logParameter("selectionArgs", args[3]);		
		_logFlush_I("android.database.sqlite.SQLiteDatabase.update(" + args[0] + ", " + args[2] + ")");
	}
}