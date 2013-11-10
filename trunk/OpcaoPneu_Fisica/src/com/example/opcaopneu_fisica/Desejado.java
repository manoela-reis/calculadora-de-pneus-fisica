package com.example.opcaopneu_fisica;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Desejado extends Activity {

	Button botao;
	RadioButton diametro;
	RadioButton altura;
	RadioButton largura;
	RadioButton velmax;
	RadioButton cargamax;
	EditText insiravalue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.desejado);
		botao = (Button) findViewById(R.id.calcular);
		diametro = (RadioButton) findViewById(R.id.diametro);
		altura = (RadioButton) findViewById(R.id.altura);
		largura = (RadioButton) findViewById(R.id.largura);
		velmax = (RadioButton) findViewById(R.id.velmax);
		cargamax = (RadioButton) findViewById(R.id.cargamax);
		insiravalue = (EditText) findViewById(R.id.insiravalor);

		if (diametro.isChecked() == true || altura.isChecked() == true
				|| largura.isChecked() == true || velmax.isChecked() == true
				|| cargamax.isChecked() == true) {

			insiravalue.setEnabled(true);
			insiravalue.setText("");

			if (insiravalue.getText() != null) {

				botao.setClickable(true);
				botao.setEnabled(true);
			}

		}
	}

	public void insira2(View v) {

		Intent i = new Intent();
		i.setClass(this, Desejado.class);
		startActivity(i);
	}

	

}
