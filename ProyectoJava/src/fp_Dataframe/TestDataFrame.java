package fp_Dataframe;
import java.util.List;

import fp_Dataframe.DataFrameImpl;
import fp_Dataframe.DataFrame;


public class TestDataFrame {
	public static void main(String[] args ) {
		
		//Personas
		DataFrame d = DataFrame.parse("persononas2.csv", List.of("Nombre","Apellido","Edad","Altura","Fecha"));
		System.out.println(d);
	
		 System.out.println("Las diez primeras filas:");
	        System.out.println(d.head(10));

	        System.out.println("\nLas diez últimas filas:");
	        System.out.println(d.tail(10));

	        System.out.println("\nLas cinco primeras filas:");
	        System.out.println(d.head(5));

	        System.out.println("\nLas cinco últimas filas:");
	        System.out.println(d.tail(5));

	        System.out.println("\nPorción entre dos valores de fila (de la 2 a la 5):");
	        System.out.println(d.slice(2, 5));

	        System.out.println("\nDataFrame después de eliminar la columna 'Nombre':");
	        System.out.println(d.removeColum("Nombre"));

	        System.out.println("\nPersonas con edad mayor a 60 años:");
	        DataFrame mayoresDe60 = d.filter(row -> Integer.parseInt(row.get(2)) > 60);
	        System.out.println(mayoresDe60);
	        
	        //Mascotas
	        
	        DataFrame e = DataFrame.parse("mascotas.csv", List.of("Id", "Mascota","Nombre","Especie","Sexo","Ubicacion","Estado"));
			System.out.println(e);
			
			 System.out.println("Las diez primeras filas:");
		        System.out.println(e.head(10));

		        System.out.println("\nLas diez últimas filas:");
		        System.out.println(e.tail(10));

		        System.out.println("\nLas cinco primeras filas:");
		        System.out.println(e.head(5));

		        System.out.println("\nLas cinco últimas filas:");
		        System.out.println(e.tail(5));

		        System.out.println("\nPorción entre dos valores de fila (de la 2 a la 5):");
		        System.out.println(e.slice(2, 5));

		        System.out.println("\nDataFrame después de eliminar la columna 'Id':");
		        System.out.println(e.removeColum("Id"));
		        
		        
		      //PP
		        
		        DataFrame l = DataFrame.parse("pp.csv", List.of("Titulo", "Valoracion", "Anyo_estreno"));
				System.out.println(l);
				
				 System.out.println("Las diez primeras filas:");
			        System.out.println(l.head(10));

			        System.out.println("\nLas diez últimas filas:");
			        System.out.println(l.tail(10));

			        System.out.println("\nLas cinco primeras filas:");
			        System.out.println(l.head(5));

			        System.out.println("\nLas cinco últimas filas:");
			        System.out.println(l.tail(5));

			        System.out.println("\nPorción entre dos valores de fila (de la 2 a la 5):");
			        System.out.println(l.slice(2, 5));

			        System.out.println("\nDataFrame después de eliminar la columna 'Titulo':");
			        System.out.println(l.removeColum("Titulo"));
		        

	}

}
