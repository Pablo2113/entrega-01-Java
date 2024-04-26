package dataframes;

import java.util.List;

import dataframes.DataFrameImpl_de_ayuda;
import fp_Dataframe.DataFrame;

public class testeo {
	public class TestDataFrame {
		public static void main(String[] args ) {
			
			//Personas
			DataFrame d = DataFrame.parse("persona.csv", List.of("Nombre","Apellido","Edad","Altura","Fecha"));
			System.out.println(d);
	
	}
}