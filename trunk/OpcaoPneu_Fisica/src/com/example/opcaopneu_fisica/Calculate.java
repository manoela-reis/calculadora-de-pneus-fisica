package com.example.opcaopneu_fisica;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Calculate extends Activity {
	static int larg;
	static int alt;
	static int diam;
	
	static EditText largura;
	static EditText altura;
	static EditText diametro;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		largura = (EditText) findViewById(R.id.largura);
		altura = (EditText) findViewById(R.id.altura);
		diametro = (EditText) findViewById(R.id.diametroo);
	}

	public void insira2 (View v){
		
		Intent i = new Intent();
		i.setClass(this, Desejado.class);
		
		startActivity(i);
	}

	public static int getLargura(){
		larg = Integer.parseInt(largura.getText().toString());
		Log.i("hueb", Integer.toString(larg));
		return larg;
	}

	public static int getAltura(){
		alt = Integer.parseInt(altura.getText().toString());
		Log.i("hueb", Integer.toString(alt));
		return alt;
	}

	public static int getDiametro(){
		diam = Integer.parseInt(diametro.getText().toString());
		Log.i("hueb", Integer.toString(diam));
		return diam;
	}
}
