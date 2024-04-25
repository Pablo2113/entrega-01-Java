package dataframes;

import java.util.List;

import dataframes.DataFrame;
import dataframes.DataFrameImpl_de_ayuda;

public class testeo {
	public class TestDataFrame {
		public static void main(String[] args ) {
			
			//Personas
			DataFrame d = DataFrame.parse("persona.csv", List.of("Nombre","Apellido","Edad","Altura","Fecha"));
			System.out.println(d);
	
	}
}