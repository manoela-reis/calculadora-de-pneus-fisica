package com.example.opcaopneu_fisica;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Calculate extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void insira2 (View v){
		
		Intent i = new Intent();
		i.setClass(this, Desejado.class);
		startActivity(i);
	}

}
