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
	private int novaAltura;
	private int novaLarg;
	private int novaAltura2;
	public Calculate calculate;
	private int alturaELarg2;
	private int alturaELarg3;
	private double somaParcial3;

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
		newDiam = Integer.parseInt(insiravalue.getText().toString());

		if (newDiam > 0 && newDiam <= 4) {

			// 1conta
			polegadasDiam = Calculate.getDiametro() * 25.4;
			alturaELarg = ((Calculate.getLargura() * Calculate.getAltura()) / 100) * 2;
			somaParcial = polegadasDiam + alturaELarg;

			// 2conta
			polegadasDiam2 = (newDiam + Calculate.getDiametro()) * 25.4;

			// 1�op��o
			if (calculate.opcao == 1) {
				novaLarg = Calculate.getLargura();
				novaAltura = Calculate.getAltura() - (newDiam * 5);

				alturaELarg2 = ((novaLarg * novaAltura) / 100) * 2;
				somaParcial2 = polegadasDiam2 + alturaELarg2;
				Toast.makeText(getApplicationContext(), Double.toString(somaParcial2) + " op1",
						Toast.LENGTH_SHORT).show();

			}

			// 2�op��o
			if (calculate.opcao == 2) {
				novaLarg = Calculate.getLargura() + (newDiam * 10);
				novaAltura2 = Calculate.getAltura() - (5 + (newDiam * 5));

				alturaELarg3 = ((novaLarg * novaAltura2) / 100) * 2;
				somaParcial3 = polegadasDiam2 + alturaELarg3;
				Toast.makeText(getApplicationContext(), Double.toString(somaParcial3) +" op2",
						Toast.LENGTH_SHORT).show();

			}

			/*
			 * if (somaParcial >= somaParcial2) {
			 * 
			 * diferen�aFinal = somaParcial - somaParcial2; } if (somaParcial <
			 * somaParcial2) {
			 * 
			 * diferen�aFinal = somaParcial2 - somaParcial; }
			 * 
			 * percent = (diferen�aFinal * 100) / somaParcial;
			 */

			/*
			 * if (percent <= 2) { Toast.makeText(getApplicationContext(),
			 * "� poss�vel", Toast.LENGTH_SHORT).show(); } else {
			 * 
			 * Toast.makeText(getApplicationContext(), "n�o � poss�vel",
			 * Toast.LENGTH_SHORT).show(); }
			 * 
			 * if (insiravalue.getText() != null) {
			 * 
			 * Toast.makeText(getApplicationContext(),
			 * Double.toString(somaParcial), Toast.LENGTH_SHORT).show(); }
			 */

		}
	}
}
