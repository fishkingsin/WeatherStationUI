/**
 * 
 */
package com.idthk.weatherstation.ui;

import com.idthk.weatherstation.ui.R;

import android.app.Activity;

/**
 * @author jameskong
 *
 */
public class Utilities {

	public static void finish(Activity context)
	{
		context.finish();
		context.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
	}
}
