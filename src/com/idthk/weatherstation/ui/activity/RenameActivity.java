package com.idthk.weatherstation.ui.activity;

import com.idthk.weatherstation.ui.Utilities;
import com.idthk.weatherstation.ui.R;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class RenameActivity extends Activity implements TextWatcher{
	TextView label;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_rename);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		setTitle(getString(R.string.RENAME));
		label = (TextView)findViewById(R.id.label);
		ImageView im = (ImageView)findViewById(R.id.station_icon);
		String item = this.getIntent().getExtras().getString(getString(R.string.station_name_extra));
		im.setImageResource(this.getIntent().getExtras().getInt(getString(R.string.station_name_icon)));
		label.setText(item);
		EditText editText1 = (EditText)findViewById(R.id.editText1);
		editText1.setText(item);
		editText1.addTextChangedListener( this);
		editText1.setSelection(item.length());
		
		Button btn_done = (Button)findViewById(R.id.btn_done);
		btn_done.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//save renamed tv;
				Utilities.finish(RenameActivity.this);
			}
			
		});
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {

		default:
			Utilities.finish(this);
			return true;
		}
	}

	@Override
	public void onBackPressed() {
		Utilities.finish(this);
	}
	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
		
		label.setText(s);
	}
}
