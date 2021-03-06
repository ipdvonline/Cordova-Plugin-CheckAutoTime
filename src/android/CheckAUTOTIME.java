package cordova.autotime.plugins2;


import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;

/*
 * thx to http://stackoverflow.com/questions/843675/how-do-i-find-out-if-the-gps-of-an-android-device-is-enabled
 */
public class CheckAUTOTIME extends CordovaPlugin{
	private int checaAuto;
	
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (action.equals("check")){
			this.check(callbackContext);
			return true;
		}
		return false;
	}
	
	private void check(CallbackContext callbackContext){
		if ((getAutoTime()) ) {
				callbackContext.success(1);
		}else{
				//callbackContext.error(0);
				callbackContext.success(0);
			}
	 }
	
	public boolean getAutoTime() {
		try {
				
			checaAuto = Settings.System.getInt(this.cordova.getActivity().getContentResolver(), android.provider.Settings.System.AUTO_TIME);

			
		} catch (SettingNotFoundException e) {
			e.printStackTrace();
		}
			
		if(checaAuto == 1){
			return true;
		}
		else
		{
			return false;
		}
	

	}


}
