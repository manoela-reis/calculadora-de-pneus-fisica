package com.example.opcaopneu_fisica;

/*Essa conta foi criada baseada na tabela encontrada na 
pirelli e neste link: https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQBpC9LuEqZnr3slT-_penJ6c9ouO5cdfcR42zryAo5a5Nn0IyN5x7H9kQ

*/
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
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
	private Boolean possivel;
	private double diferençaFinal;
	TextView resultado;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.desejado);

		initialize();
	}

	private void initialize() {

		diametro = (RadioButton) findViewById(R.id.diametroo);
		botao = (Button) findViewById(R.id.calcular1);
		insiravalue = (EditText) findViewById(R.id.valor);
		resultado = (TextView) findViewById(R.id.resultado);

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
			
			// 1ºopção
			if (calculate.opcao == 1) {
				novaLarg = Calculate.getLargura();
				novaAltura = Calculate.getAltura() - (newDiam * 5);

				alturaELarg2 = ((novaLarg * novaAltura) / 100) * 2;
				somaParcial2 = polegadasDiam2 + alturaELarg2;
				
				//Para Teste
				//Toast.makeText(getApplicationContext(), Double.toString(somaParcial2) + " op1",
				//		Toast.LENGTH_SHORT).show();
				
				CalculatePossibility1();
				
				if(possivel==true){
					resultado.setText(Double.toString(novaLarg) + " / " + Double.toString(novaAltura) + " / " + Double.toString(newDiam + Calculate.getDiametro()) );
				}else{
					DialogHelper.message(this,
							"De acordo com a legislação brasileira, não é possível utilizar essa nova medida no seu carro. Verifique se as medidas estão corretas e tente novamente.");
					
				}

			}
			
			// 2ºopção
			if (calculate.opcao == 2) {
				novaLarg = Calculate.getLargura() + (newDiam * 10);
				novaAltura2 = Calculate.getAltura() - (5 + (newDiam * 5));

				alturaELarg3 = ((novaLarg * novaAltura2) / 100) * 2;
				somaParcial3 = polegadasDiam2 + alturaELarg3;
				
				//Para Teste
				//Toast.makeText(getApplicationContext(), Double.toString(somaParcial3) +" op2",
				//		Toast.LENGTH_SHORT).show();
				
				CalculatePossibility2();
				
				if(possivel==true){
					resultado.setText(Double.toString(novaLarg) + " / " + Double.toString(novaAltura2) + " / " + Double.toString(newDiam + Calculate.getDiametro()) );
				}else{
					
					DialogHelper.message(this,
							"De acordo com a legislação brasileira, não é possível utilizar essa nova medida no seu carro. Verifique se as medidas estão corretas e tente novamente.");
					
				}

			}

		}else{
			
			DialogHelper.message(this,
					"De acordo com a legislação brasileira, não é possível utilizar essa nova medida no seu carro. Verifique se as medidas estão corretas e tente novamente.");
			
		}
		}
		
	
	public Boolean CalculatePossibility1(){
		if (somaParcial >= somaParcial2) {
			 
			 diferençaFinal = somaParcial - somaParcial2; 
		}
		
		if (somaParcial < somaParcial2) {
			 diferençaFinal = somaParcial2 - somaParcial; 
		}			 
			 percent = (diferençaFinal * 100) / somaParcial;
			 
		if(percent <= 2){
			possivel = true;
		}else{
			possivel= false;
		}
		return possivel;
	}
	
	public Boolean CalculatePossibility2(){
		if (somaParcial >= somaParcial3) {
			 
			 diferençaFinal = somaParcial - somaParcial3; 
		}
		if (somaParcial < somaParcial3) {
			 diferençaFinal = somaParcial3 - somaParcial; 
		}
			 
			 percent = (diferençaFinal * 100) / somaParcial;
		if(percent <= 2){
			possivel = true;
		}else{
			possivel= false;
		}
		return possivel;
	}
}
