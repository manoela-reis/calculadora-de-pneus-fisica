package com.example.opcaopneu_fisica;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gotothenext);
	}

	public void insira (View sender){
		
		Intent i = new Intent();
		i.setClass(this, Calculate.class);
		startActivity(i);
	}
	


}
