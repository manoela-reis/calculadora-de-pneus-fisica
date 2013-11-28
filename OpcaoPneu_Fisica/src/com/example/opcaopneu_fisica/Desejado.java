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
	double percent;
	double somaParcial;

	double polegadasDiam2;

	int newDiam;
	private double somaParcial2;
	private double diferençaFinal;
	private int novaAltura;
	private int novaLarg;
	private int novaAltura2;
	public Calculate calculate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.desejado);

		initialize();
	}

	private void initialize() {

		diametro = (RadioButton) findViewById(R.id.diametroo);
		botao = (Button) findViewById(R.id.calcular);
		insiravalue = (EditText) findViewById(R.id.valor);
	}

	public void diametro(View v) {
		botao.setEnabled(true);
	}

	public void calcula(View v) {

		polegadasDiam = Calculate.getDiametro() * 25.4;
		alturaELarg = ((Calculate.getLargura() * Calculate.getAltura()) / 100) * 2;
		somaParcial = polegadasDiam + alturaELarg;

		newDiam = Integer.parseInt(insiravalue.getText().toString());

		//1ºopção
		if (calculate.opcao == 2) {
			novaLarg = Calculate.getLargura();
			novaAltura = Calculate.getAltura() - (newDiam * 5);
			Toast.makeText(getApplicationContext(), 
					Double.toString(novaAltura), Toast.LENGTH_SHORT).show();
		}
		
		//2ºopção
		if (calculate.opcao == 1) {
			novaLarg = Calculate.getLargura() + (newDiam *10);
			novaAltura2 =  Calculate.getAltura() - (5 + (newDiam *5));
			Toast.makeText(getApplicationContext(), 
					Double.toString(novaAltura2), Toast.LENGTH_SHORT).show();
		}
		
		/*
		if (somaParcial >= somaParcial2) {

			diferençaFinal = somaParcial - somaParcial2;
		}
		if (somaParcial < somaParcial2) {

			diferençaFinal = somaParcial2 - somaParcial;
		}

		percent = (diferençaFinal * 100) / somaParcial;*/

		

		/*if (percent <= 2) {
			Toast.makeText(getApplicationContext(), "é possível",
					Toast.LENGTH_SHORT).show();
		} else {

			Toast.makeText(getApplicationContext(), "não é possível",
					Toast.LENGTH_SHORT).show();
		}

		if (insiravalue.getText() != null) {

			Toast.makeText(getApplicationContext(),
					Double.toString(somaParcial), Toast.LENGTH_SHORT).show();
		}*/

	}

}
