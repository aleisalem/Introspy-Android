package com.introspy.custom_hooks;

import com.introspy.core.HookConfig;

import java.io.File;
import java.nio.ByteBuffer;
import java.net.Socket;
import java.net.URL;

import android.accounts.Account;
import android.app.DownloadManager.Request;
import android.app.DownloadManager.Query;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import java.net.Proxy;

public class CustomHookList {
	
	static public HookConfig[] getHookList() {
		return _hookList;
	}
	
	static private HookConfig[] _hookList = new HookConfig[] {	
		
		new HookConfig(false, // set to false to enable the hook
			"android.content.ContextWrapper", "startService", new Class<?>[]{Intent.class},
			// class, 						   method name, 				 arguments
			new HookExampleImpl(), 
			// instance of the implementation extending IntroHook (here in HookExampleInpl.java)
			"StartService with an intent as argument"),
			// notes (optional)
		
		// Hooking android.accounts.AccountManager
		// android.accounts.AccountManager.clearPassword(Account account)
		new HookConfig(true,
				"android.accounts.AccountManager", "clearPassword", new Class<?>[]{Account.class},
				new Intro_AccountManager_clearPassword(),
				"clearPassword"),
		// android.accounts.AccountManager.getAccounts()
		new HookConfig(true,
				"android.accounts.AccountManager", "getAccounts", new Class<?>[]{},
				new Intro_AccountManager_getAccounts(),
				"getAccounts"),
		// android.accounts.AccountManager.getPassword(Account account)
		new HookConfig(true,
				"android.accounts.AccountManager", "getPassword", new Class<?>[]{Account.class},
				new Intro_AccountManager_getPassword(),
				"getPassword"),
		// android.accounts.AccountManager.peekAuthToken(Account account, String authTokenType)
		new HookConfig(true,
				"android.accounts.AccountManager", "peekAuthToken", new Class<?>[]{Account.class, String.class},
				new Intro_AccountManager_peekAuthToken(),
				"peekAuthToken"),
		// android.accounts.AccountManager.removeAccount(Account, Activity, AccountManagerCallback, Handler)
//		new HookConfig(true,
//				"android.accounts.AccountManager", "removeAccount", new Class<?>[]{Account.class, Activity.class, AccountManagerCallBack.class, Handler.class},
//				new Intro_AccountManager_removeAccount(),
//				"removeAccount"),
		// android.accounts.AccountManager.setAuthToken(Account, String authTokenType, String authToken)
		new HookConfig(true,
				"android.accounts.AccountManager", "setAuthToken", new Class<?>[]{Account.class, String.class, String.class},
				new Intro_AccountManager_setAuthToken(),
				"setAuthToken"),
		
		// android.accounts.AccountManager.setPassword(Account account, String password)
		new HookConfig(true,
				"android.accounts.AccountManager", "setPassword", new Class<?>[]{Account.class, String.class},
				new Intro_AccountManager_setPassword(),
				"setPassword"),
		// End of Hooking android.accounts.AccountManager
		
		
		// Hooking android.app.Activity methods
		// android.app.Activity.startActivity(Intent, Bundle)
		new HookConfig(true,
				"android.app.Activity", "startActivity", new Class<?>[]{Intent.class, Bundle.class},
				new Intro_Activity_startActivity(),
				"Starting Activity"),
		// android.app.Activity.setContentView(View)
		new HookConfig(true,
				"android.app.Activity", "setContentView", new Class<?>[]{View.class},
				new Intro_Activity_setContentView(),
				"SetContentView for Activity"),
		// android.app.Activity.setVisible(boolean)
		new HookConfig(true,
				"android.app.Activity", "setVisible", new Class<?>[]{boolean.class},
				new Intro_Activity_setVisible(),
				"SetVisible"),
		// android.app.Activity.takeKeyEvents(boolean)
		new HookConfig(true,
				"android.app.Activity", "takeKeyEvents", new Class<?>[]{boolean.class},
				new Intro_Activity_takeKeyEvents(),
				"takeKeyEvents"),
		// End of Hooking android.app.Activity methods
		
		// Hooking android.app.DownloadManager
		// android.app.DownloadManager.addCompletedDownload(String, String, boolean, String, String, long, boolean)
		new HookConfig(true,
				"android.app.DownloadManager", "addCompletedDownload", new Class<?>[]{String.class, String.class, boolean.class, String.class, String.class, long.class, boolean.class},
				new Intro_DownloadManager_addCompletedDownload(),
				"addCompletedDownload"),
		// android.app.DownloadManager.enqueue(DownloadManager.Request
		new HookConfig(true,
				"android.app.DownloadManager", "enqueue", new Class<?>[]{Request.class},
				new Intro_DownloadManager_enqueue(),
				"enqueue"),
		// android.app.DownloadManager.getUriForDownloadedFile(long)
		new HookConfig(true,
				"android.app.DownloadManager", "getUriForDownloadedFile", new Class<?>[]{long.class},
				new Intro_DownloadManager_getURIForDownloadedFile(),
				"getUriForDownloadedFile"),
		// android.app.DownloadManager.openDownloadedFile
		new HookConfig(true,
				"android.app.DownloadManager", "openDownloadedFile", new Class<?>[]{long.class},
				new Intro_DownloadManager_openDownloadedFile(),
				"openDownloadedFile"),
		// android.app.DownloadManager.query
		new HookConfig(true,
				"android.app.DownloadManager", "query", new Class<?>[]{Query.class},
				new Intro_DownloadManager_query(),
				"query"),		
		// End of Hooking android.app.DownloadManager
		
		// Hooking android.app.IntentService
		// android.app.IntentService.onStartCommand
		new HookConfig(true,
				"android.app.IntentService", "onStartCommand", new Class<?>[]{Intent.class, Integer.TYPE, Integer.TYPE},
				new Intro_IntentService_onStartCommand(),
				"onStartCommand"),
		// End of Hooking android.app.IntentService
		
		// Hooking android.content.ContentResolver
		// android.content.ContentResolver.delete(Uri, String, String[])
		new HookConfig(true,
				"android.content.ContentResolver", "delete", new Class<?>[]{Uri.class, String.class, String[].class},
				new Intro_ContentResolver_delete(),
				"delete"),
		
		// android.content.ContentResolver.insert(Uri, ContentValues)
		new HookConfig(true,
				"android.content.ContentResolver", "insert", new Class<?>[]{Uri.class, ContentValues.class},
				new Intro_ContentResolver_insert(),
				"insert"),
		// android.content.ContentProvider.openFileDescriptor(Uri uri, String mode)
		new HookConfig(true,
				"android.content.ContentResolver", "openFileDescriptor", new Class<?>[]{Uri.class, String.class},
				new Intro_ContentResolver_openFileDescriptor(),
				"openFile"),		
		// android.content.ContentProvider.query(Uri, String[], String, String[], String)
		new HookConfig(true,
				"android.content.ContentResolver", "query", new Class<?>[]{Uri.class, String[].class, String.class, String[].class, String.class},
				new Intro_ContentResolver_query(),
				"query"),		
		// android.content.ContentProvider.update(Uri, ContentValues, String, String[])
		new HookConfig(true,
				"android.content.ContentResolver", "update", new Class<?>[]{Uri.class, ContentValues.class, String.class, String[].class},
				new Intro_ContentResolver_update(),
				"update"),		
		// End of Hooking android.content.ContentProvider
		
		// Hooking android.content.ContextWrapper
		// android.content.ContextWrapper.bindService(Intent, ServiceConnection, int)
		new HookConfig(true,
				"android.content.ContextWrapper", "bindService", new Class<?>[]{Intent.class, ServiceConnection.class, Integer.TYPE},
				new Intro_ContextWrapper_bindService(),
				"bindService"),
		// android.content.ContextWrapper.deleteDatabase(String)
		new HookConfig(true,
				"android.content.ContextWrapper", "deleteDatabase", new Class<?>[]{String.class},
				new Intro_ContextWrapper_deleteDatabase(),
				"deleteDatabase"),
		// android.content.ContextWrapper.deleteFile(String)
		new HookConfig(true,
				"android.content.ContextWrapper", "deleteFile", new Class<?>[]{String.class},
				new Intro_ContextWrapper_deleteFile(),
				"deleteFile"),
		// android.content.ContextWrapper.deleteSharedPreferences(String)
		new HookConfig(true,
				"android.content.ContextWrapper", "deleteSharedPreferences", new Class<?>[]{String.class},
				new Intro_ContextWrapper_deleteSharedPreferences(),
				"deleteSharedPreferences"),
		// android.content.ContextWrapper.getSystemService
		new HookConfig(true,
				"android.content.ContextWrapper", "getSystemService", new Class<?>[]{String.class},
				new Intro_ContextWrapper_getSystemService(),
				"getSystemService"),
		// android.content.ContextWrapper.openFileInput(String)
		new HookConfig(true,
				"android.content.ContextWrapper", "openFileInput", new Class<?>[]{String.class},
				new Intro_ContextWrapper_openFileInput(),
				"openFileInput"),
		// android.content.ContextWrapper.openFileOutput(String)							[Implemented as part of IPC]
		// android.content.ContextWrapper.registerReceiver(BroadcastReceiver, IntentFilter) [Implemented as part of IPC]
		// android.content.ContextWrapper.sendBroadcast(Intent) 							[Implemented as part of IPC]
		// android.content.ContextWrapper.startService(Intent) 								[Implemented as part of IPC]
		// android.content.ContextWrapper.stopService(Intent)
		new HookConfig(true,
				"android.content.ContextWrapper", "stopService", new Class<?>[]{String.class},
				new Intro_ContextWrapper_stopService(),
				"stopService"),
		// android.content.ContextWrapper.unbindService(ServiceConnection)
		new HookConfig(true,
				"android.content.ContextWrapper", "unbindService", new Class<?>[]{ServiceConnection.class},
				new Intro_ContextWrapper_unbindService(),
				"unbindService"),
		// android.content.ContextWrapper.unregisterReceiver(BroadcastReceiver)
		new HookConfig(true,
				"android.content.ContextWrapper", "unregisterReceiver", new Class<?>[]{BroadcastReceiver.class},
				new Intro_ContextWrapper_unregisterReceiver(),
				"unregisterReceiver"),
		// End of Hooking android.content.ContextWrapper
		
		// Hooking android.content.pm.PackageInstaller
		// android.content.pm.PackageInstaller.uninstall(String packageName, IntentSender statusReceiver)
		new HookConfig(true,
				"android.content.pm.PackageInstaller", "uninstall", new Class<?>[]{String.class, IntentSender.class},
				new Intro_PackageInstaller_uninstall(),
				"uninstall"),
		// End of Hooking android.content.pm.PackageInstaller
		
		// Hooking android.database.sqlite.SQLiteDatabase
		// android.database.sqlite.SQLiteDatabase.create(SQLiteDatabase.CursorFactory factory)
		new HookConfig(true,
				"android.database.sqlite.SQLiteDatabase", "create", new Class<?>[]{SQLiteDatabase.CursorFactory.class},
				new Intro_SQLiteDatabase_create(),
				"create"),
		// android.database.sqlite.SQLiteDatabase.delete(String table, String whereClause, String[] whereArgs)
		new HookConfig(true,
				"android.database.sqlite.SQLiteDatabase", "delete", new Class<?>[]{String.class, String.class, String[].class},
				new Intro_SQLiteDatabase_delete(),
				"delete"),
		// android.database.sqlite.SQLiteDatabase.deleteDatabase(File file)
		new HookConfig(true,
				"android.database.sqlite.SQLiteDatabase", "deleteDatabase", new Class<?>[]{File.class},
				new Intro_SQLiteDatabase_deleteDatabase(),
				"deleteDatabase"),
		// android.database.sqlite.SQLiteDatabase.execSQL(String sql)
		new HookConfig(true,
				"android.database.sqlite.SQLiteDatabase", "execSQL", new Class<?>[]{String.class},
				new Intro_SQLiteDatabase_execSQL(),
				"execSQL"),
		// android.database.sqlite.SQLiteDatabase.execSQL(String sql, Object[] bindArgs)
		new HookConfig(true,
				"android.database.sqlite.SQLiteDatabase", "execSQL", new Class<?>[]{String.class, Object[].class},
				new Intro_SQLiteDatabase_execSQL2(),
				"execSQL"),
		// android.database.sqlite.SQLiteDatabase.insert(String table, String nullColumnHack, ContentValues values)
		new HookConfig(true,
				"android.database.sqlite.SQLiteDatabase", "insert", new Class<?>[]{String.class, String.class, ContentValues.class},
				new Intro_SQLiteDatabase_insert(),
				"insert"),
		// android.database.sqlite.SQLiteDatabase.insertOrThrow(String table, String nullColumnHack, ContentValues values)
		new HookConfig(true,
				"android.database.sqlite.SQLiteDatabase", "insertOrThrow", new Class<?>[]{String.class, String.class, ContentValues.class},
				new Intro_SQLiteDatabase_insertOrThrow(),
				"insertOrThrow"),
		// android.database.sqlite.SQLiteDatabase.openDatabase(String path, SQLiteDatabase.CursorFactory factory, int flags)
		new HookConfig(true,
				"android.database.sqlite.SQLiteDatabase", "openDatabase", new Class<?>[]{String.class, SQLiteDatabase.CursorFactory.class, Integer.TYPE},
				new Intro_SQLiteDatabase_openDatabase(),
				"openDatabase"),
		// android.database.sqlite.SQLiteDatabase.query(boolean distinct, String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit)
		new HookConfig(true,
				"android.database.sqlite.SQLiteDatabase", "query", new Class<?>[]{Boolean.TYPE, String.class, String[].class, String.class, String[].class, String.class, String.class, String.class, String.class},
				new Intro_SQLiteDatabase_query(),
				""),
		// android.database.sqlite.SQLiteDatabase.query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit)
		new HookConfig(true,
				"android.database.sqlite.SQLiteDatabase", "query", new Class<?>[]{String.class, String[].class, String.class, String[].class, String.class, String.class, String.class, String.class},
				new Intro_SQLiteDatabase_query2(),
				"query"),
		// android.database.sqlite.SQLiteDatabase.query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy)
		new HookConfig(true,
				"android.database.sqlite.SQLiteDatabase", "query", new Class<?>[]{String.class, String[].class, String.class, String[].class, String.class, String.class, String.class},
				new Intro_SQLiteDatabase_query4(),
				"query"),
		// android.database.sqlite.SQLiteDatabase.rawQuery(String sql, String[] selectionArgs)
		new HookConfig(true,
				"android.database.sqlite.SQLiteDatabase", "rawQuery", new Class<?>[]{String.class, String[].class},
				new Intro_SQLiteDatabase_rawQuery2(),
				"rawQuery"),
		// android.database.sqlite.SQLiteDatabase.replace(String table, String nullColumnHack, ContentValues initialValues) 
		new HookConfig(true,
				"android.database.sqlite.SQLiteDatabase", "replace", new Class<?>[]{String.class, String.class, ContentValues.class},
				new Intro_SQLiteDatabase_replace(),
				"replace"),
		// android.database.sqlite.SQLiteDatabase.update(String table, ContentValues values, String whereClause, String[] whereArgs)
		new HookConfig(true,
				"android.database.sqlite.SQLiteDatabase", "update", new Class<?>[]{String.class, ContentValues.class, String.class, String[].class},
				new Intro_SQLiteDatabase_update(),
				"update"),
		// End of Hooking android.database.sqlite.SQLiteDatabase
		
		// Hooking android.hardware.Camera
		// android.hardware.Camera.open()
		new HookConfig(true,
				"android.hardware.Camera", "open", new Class<?>[]{},
				new Intro_Camera_open(),
				"open"),
		// android.hardware.Camera.reconnect()
		new HookConfig(true,
				"android.hardware.Camera", "reconnect", new Class<?>[]{},
				new Intro_Camera_reconnect(),
				"reconnect"),
		// android.hardware.Camera.release()
		new HookConfig(true,
				"android.hardware.Camera", "release", new Class<?>[]{},
				new Intro_Camera_release(),
				"release"),
		// android.hardware.Camera.startPreview()
		new HookConfig(true,
				"android.hardware.Camera", "startPreview", new Class<?>[]{},
				new Intro_Camera_startPreview(),
				"startPreview"),
		// android.hardware.Camera.stopPreview()
		new HookConfig(true,
				"android.hardware.Camera", "stopPreview", new Class<?>[]{},
				new Intro_Camera_stopPreview(),
				"stopPreview"),
		// android.hardware.Camera.takePicture(Camera.ShutterCallback, Camera.PictureCallback, Camera.PictureCallback)
		new HookConfig(true,
				"android.hardware.Camera", "takePicture", new Class<?>[]{Camera.ShutterCallback.class, Camera.PictureCallback.class, Camera.PictureCallback.class},
				new Intro_Camera_takePicture(),
				"takePicture"),
		// End of Hooking android.hardware.Camera 
		
		// Hooking android.hardware.display.DisplayManager
		// android.hardware.display.DisplayManager.getDisplay(int displayId)
		new HookConfig(true,
				"android.hardware.display.DisplayManager", "getDisplay", new Class<?>[]{Integer.TYPE},
				new Intro_DisplayManager_getDisplay(),
				"getDisplay"),
		// android.hardware.display.DisplayManager.getDisplays()
		new HookConfig(true,
				"android.hardware.display.DisplayManager", "getDisplays", new Class<?>[]{},
				new Intro_DisplayManager_getDisplays(),
				"getDisplays"),		
		// End of Hooking android.hardware.display.DisplayManager 
		
		// Hooking android.location.Location
		// android.location.Location.getLatitude()
		new HookConfig(true,
				"android.location.Location", "getLatitude", new Class<?>[]{},
				new Intro_Location_getLatitude(),
				"getLatitude"),
		// android.location.Location.getLongitude()
		new HookConfig(true,
				"android.location.Location", "getLongitude", new Class<?>[]{},
				new Intro_Location_getLongitude(),
				"getLongitude"),
		// End of Hooking android.location.Location
		
		// Hooking android.media.AudioRecord
		// android.media.AudioRecord.read(short[], int, int)
		new HookConfig(true,
				"android.media.AudioRecord_read", "read", new Class<?>[]{short[].class, Integer.TYPE, Integer.TYPE},
				new Intro_AudioRecord_read(),
				"read"),
		// android.media.AudioRecord.read(ByteBuffer, int)
		new HookConfig(true,
				"android.media.AudioRecord", "read", new Class<?>[]{ByteBuffer.class, Integer.TYPE},
				new Intro_AudioRecord_read2(),
				"read"),		
		// android.media.AudioRecord.read(byte[], int, int)
		new HookConfig(true,
				"android.media.AudioRecord", "read", new Class<?>[]{byte[].class, Integer.TYPE, Integer.TYPE},
				new Intro_AudioRecord_read3(),
				"read"),		
		// android.media.AudioRecord.startRecording()
		new HookConfig(true,
				"android.media.AudioRecord", "startRecording", new Class<?>[]{},
				new Intro_AudioRecord_startRecording(),
				"startRecording"),		
		// android.media.AudioRecord.stop()
		new HookConfig(true,
				"android.media.AudioRecord", "stop", new Class<?>[]{},
				new Intro_AudioRecord_stop(),
				"stop"),		
		// End of Hooking android.media.AudioRecord
		
		// Hooking android.media.MediaRecorder
		// android.media.MediaRecorder.prepare()
		new HookConfig(false,
				"android.media.MediaRecorder", "prepare", new Class<?>[]{},
				new Intro_MediaRecorder_prepare(),
				"prepare"),
		// android.media.MediaRecorder.setCamera(Camera)
		new HookConfig(false,
				"android.media.MediaRecorder", "setCamera", new Class<?>[]{Camera.class},
				new Intro_MediaRecorder_setCamera(),
				"setCamera"),		
		// android.media.MediaRecorder.start()
		new HookConfig(false,
				"android.media.MediaRecorder", "start", new Class<?>[]{},
				new Intro_MediaRecorder_start(),
				"start"),		
		// android.media.MediaRecorder.stop()
		new HookConfig(false,
				"android.media.MediaRecorder", "stop", new Class<?>[]{},
				new Intro_MediaRecorder_stop(),
				"stop"),		
		// End of Hooking android.media.MediaRecorder

		// Hooking android.net.Network
		// android.net.Network.bindSocket(Socket)
		new HookConfig(true, 
				"android.net.Network", "bindSocket", new Class<?>[]{Socket.class},
				new Intro_Network_bindSocket(),
				"bindSocket"),
		// android.net.Network.openConnection(URL)
		new HookConfig(true,
				"android.net.Network", "openConnection", new Class<?>[]{URL.class},
				new Intro_Network_openConnection(),
				"openConnection"),
		// End of Hooking android.net.Network
		
		// Hooking android.net.NetworkInfo
		// android.net.NetworkInfo.isAvailable()
		new HookConfig(true, 
				"android.net.NetworkInfo", "isAvailable", new Class<?>[]{},
				new Intro_NetworkInfo_isAvailable(),
				"isAvailable"),
		// android.net.NetworkInfo.isConnected()
		new HookConfig(true, 
				"android.net.NetworkInfo", "isConnected", new Class<?>[]{},
				new Intro_NetworkInfo_isConnected(),
				"isConnected"),		
		// android.net.NetworkInfo.isRoaming()		
		new HookConfig(true, 
				"android.net.NetworkInfo", "isRoaming", new Class<?>[]{},
				new Intro_NetworkInfo_isRoaming(),
				"isRoaming"),
		// End of Hooking android.net.NetworkInfo
		
		
		// Hooking android.net.wifi.WifiInfo
		// android.net.wifi.WifiInfo.getMacAddress()
		new HookConfig(true, 
				"android.net.wifi.WifiInfo", "getMacAddress", new Class<?>[]{},
				new Intro_WifiInfo_getMacAddress(),
				"getMacAddress"),
		// android.net.wifi.WifiInfo.getSSID()
		new HookConfig(true, 
				"android.net.wifi.WifiInfo", "getSSID", new Class<?>[]{},
				new Intro_WifiInfo_getSSID(),
				"getSSID"),
		// End of Hooking android.net.wifi.WifiInfo
		
		// Hooking android.net.wifi.WifiManager
		// android.net.wifi.WifiManager.disconnect()
		new HookConfig(true, 
				"android.net.wifi.WifiManager", "disconnect", new Class<?>[]{},
				new Intro_WifiManager_disconnect(),
				"disconnect"),
		// android.net.wifi.WifiManager.getScanResults()
		new HookConfig(true, 
				"android.net.wifi.WifiManager", "getScanResults", new Class<?>[]{},
				new Intro_WifiManager_getScanResults(),
				"getScanResults"),		
		// android.net.wifi.WifiManager.getWifiState()
		new HookConfig(true, 
				"android.net.wifi.WifiManager", "getWifiState", new Class<?>[]{},
				new Intro_WifiManager_getWifiState(),
				"getWifiState"),		
		// android.net.wifi.WifiManager.reconnect()
		new HookConfig(true, 
				"android.net.wifi.WifiManager", "reconnect", new Class<?>[]{},
				new Intro_WifiManager_reconnect(),
				"reconnect"),		
		// android.net.wifi.WifiManager.startScan()
		new HookConfig(true, 
				"android.net.wifi.WifiManager", "startScan", new Class<?>[]{},
				new Intro_WifiManager_startScan(),
				"startScan"),		
		// End of Hooking android.net.wifi.WifiManager
		
		// Hooking android.os.Process
		// android.os.Process.killProcess(int)
		new HookConfig(true,
				"android.os.Process", "killProcess", new Class<?>[]{Integer.TYPE},
				new Intro_Process_killProcess(),
				"killProcess"),
		// End of Hooking android.os.Process
		
		// Hooking android.os.PowerManager
		// android.os.PowerManager.isInteractive()
		new HookConfig(true,
				"android.os.PowerManager", "isInteractive", new Class<?>[]{},
				new Intro_PowerManager_isInteractive(),
				"isInteractive"),
		// android.os.PowerManager.isScreenOn()
		new HookConfig(true,
				"android.os.PowerManager", "isScreenOn", new Class<?>[]{},
				new Intro_PowerManager_isScreenOn(),
				"isScreenOn"),		
		// android.os.PowerManager.reboot(String reasons)
		new HookConfig(true,
				"android.os.PowerManager", "reboot", new Class<?>[]{String.class},
				new Intro_PowerManager_reboot(),
				"reboot"),		
		// End of Hooking android.os.PowerManager
		
		// Hooking android.telephony.SmsManager
		// android.telephony.SmsManager.sendDataMessage(String, String, short, byte[], PendingIntent, PendingIntent)
		new HookConfig(true,
				"android.telephony.SmsManager", "sendDataMessage", new Class<?>[]{String.class, String.class, short.class, byte[].class, PendingIntent.class, PendingIntent.class},
				new Intro_SmsManager_sendDataMessage(),
				"sendDataMessage"),
		// android.telephony.SmsManager.sendTextMessage(String, String, String, PendingIntent, PendingIntent)
		new HookConfig(true,
				"android.telephony.SmsManager", "sendTextMessage", new Class<?>[]{String.class, String.class, String.class, PendingIntent.class, PendingIntent.class},
				new Intro_SmsManager_sendTextMessage(),
				"sendTextMessage"),		
		// End of Hooking android.telephony.SmsManager

		// Hooking android.widget.Toast
		// android.widget.Toast.makeText(Context context, int resId, int duration)
		new HookConfig(true,
				"android.widget.Toast", "makeText", new Class<?>[]{Context.class, Integer.TYPE},
				new Intro_Toast_makeText(),
				"makeText"),
		// android.widget.Toast.makeText(Context context, CharSequence text, int duration)
		new HookConfig(true,
				"android.widget.Toast", "makeText", new Class<?>[]{Context.class, CharSequence.class, Integer.TYPE},
				new Intro_Toast_makeText2(),
				"makeText"),
		// End of Hooking android.widget.Toast
		
		// Hooking java.lang.class
		// java.lang.class.forName(String name, boolean initialize, ClassLoader loader)
		new HookConfig(true,
				"java.lang.class", "forName", new Class<?>[]{String.class, Boolean.TYPE, ClassLoader.class}, 
				new Intro_Class_forName(),
				"forName"),
		// java.lang.class.forName(String className)
		new HookConfig(true,
				"java.lang.class", "forName", new Class<?>[]{String.class}, 
				new Intro_Class_forName2(),
				"forName"),		
		// java.lang.class.getClassLoader()
		new HookConfig(true,
				"java.lang.class", "getClassLoader", new Class<?>[]{}, 
				new Intro_Class_getClassLoader(),
				"getClassLoader"),		
		// java.lang.class.getClasses()
		new HookConfig(true,
				"java.lang.class", "getClasses", new Class<?>[]{}, 
				new Intro_Class_getClasses(),
				"getClasses"),
		// java.lang.class.getField(String name)
		new HookConfig(true,
				"java.lang.class", "getField", new Class<?>[]{String.class}, 
				new Intro_Class_getField(),
				"getField"),
		// java.lang.class.getFields()
		new HookConfig(true,
				"java.lang.class", "getFields", new Class<?>[]{}, 
				new Intro_Class_getFields(),
				"getFields"),		
		// java.lang.class.getMethods()
		new HookConfig(true,
				"java.lang.class", "getMethods", new Class<?>[]{}, 
				new Intro_Class_getMethods(),
				"getMethods"),
		// java.lang.class.getName()
		new HookConfig(true,
				"java.lang.class", "getName", new Class<?>[]{}, 
				new Intro_Class_getName(),
				"getName"),		
		// End of Hooking java.lang.class
		
		// Hooking java.net.HttpCookie
		// java.net.HttpCookie.getName()
		new HookConfig(true,
				"java.net.HttpCookie", "getName", new Class<?>[]{},
				new Intro_HttpCookie_getName(),
				"getName"),
		// java.net.HttpCookie.getPath()
		new HookConfig(true,
				"java.net.HttpCookie", "getPath", new Class<?>[]{},
				new Intro_HttpCookie_getPath(),
				"getPath"),		
		// java.net.HttpCookie.getSecure()
		new HookConfig(true,
				"java.net.HttpCookie", "getSecure", new Class<?>[]{},
				new Intro_HttpCookie_getSecure(),
				"getSecure"),		
		// java.net.HttpCookie.getValue()
		new HookConfig(true,
				"java.net.HttpCookie", "getValue", new Class<?>[]{},
				new Intro_HttpCookie_getValue(),
				"getValue"),		
		// java.net.HttpCookie.parse(String header)
		new HookConfig(true,
				"java.net.HttpCookie", "parse", new Class<?>[]{String.class},
				new Intro_HttpCookie_parse(),
				"parse"),		
		// java.net.HttpCookie.setPath(String uri)
		new HookConfig(true,
				"java.net.HttpCookie", "setPath", new Class<?>[]{String.class},
				new Intro_HttpCookie_setPath(),
				"setPath"),		
		// java.net.HttpCookie.setSecure(boolean flag)
		new HookConfig(true,
				"java.net.HttpCookie", "setSecure", new Class<?>[]{Boolean.TYPE},
				new Intro_HttpCookie_setSecure(),
				"setSecure"),		
		// java.net.HttpCookie.setValue(String newValue)
		new HookConfig(true,
				"java.net.HttpCookie", "setValue", new Class<?>[]{String.class},
				new Intro_HttpCookie_setValue(),
				"setValue"),		
		// End of Hooking java.net.HttpCookie
		
		// Hooking java.net.URL
		// java.net.URL.openConnection(Proxy proxy)
		new HookConfig(true,
				"java.net.URL", "openConnection", new Class<?>[]{Proxy.class},
				new Intro_URL_openConnection(),
				"openConnection"),
		// java.net.URL.openConnection()
		new HookConfig(true,
				"java.net.URL", "openConnection", new Class<?>[]{},
				new Intro_URL_openConnection(),
				"openConnection2"),		
		// java.net.URL.openStream()
		new HookConfig(true,
				"java.net.URL", "openStream", new Class<?>[]{},
				new Intro_URL_openStream(),
				"openStream"),		
		// End of Hooking java.net.URL
		
	};
}

