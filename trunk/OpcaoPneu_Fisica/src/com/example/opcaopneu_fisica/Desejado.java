package com.example.opcaopneu_fisica;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class Desejado extends Activity {

	Button botao;
	RadioButton diametro;
	EditText insiravalue;
	double polegadasDiam;
	double alturaELarg;
	double percentAlt;
	double somaParcial;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.desejado);

		/*
		 * if (diametro.isChecked() == true || altura.isChecked() == true ||
		 * largura.isChecked() == true || velmax.isChecked() == true ||
		 * cargamax.isChecked() == true) {
		 * 
		 * insiravalue.setEnabled(true); insiravalue.setText("");
		 * 
		 * if (insiravalue.getText() != null) {
		 * 
		 * botao.setClickable(true); botao.setEnabled(true); }
		 * 
		 * }
		 */
		initialize();
	}


	private void initialize() {
		
		diametro = (RadioButton) findViewById(R.id.diametroo);
		botao = (Button) findViewById(R.id.calcular);	
		insiravalue = (EditText) findViewById(R.id.altura);
	}

	public void insira2(View v) {
		Intent i = new Intent();
		i.setClass(this, Desejado.class);
		startActivity(i);
	}
	public void diametro(View v) {
		botao.setEnabled(true);
	}
	public void calcula(View v) {
		
		 polegadasDiam = Calculate.getDiametro() * 25.4;
		 percentAlt = Calculate.getAltura()/100;
		 alturaELarg = (Calculate.getLargura() * percentAlt) * 2;
		 somaParcial = polegadasDiam + alturaELarg;
		 
		 //Log.i("oi", Double.toString(somaParcial));
		 Toast.makeText(getApplicationContext(), Double.toString(percentAlt), Toast.LENGTH_SHORT).show();
			
		 
		/*if(insiravalue.getText() != null){
			
			Toast.makeText(getApplicationContext(), Double.toString(somaParcial), Toast.LENGTH_SHORT).show();
		}*/
		
		
	}

}
