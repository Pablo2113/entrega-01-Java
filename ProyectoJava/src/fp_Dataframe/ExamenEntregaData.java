package fp_Dataframe;


import fp_Dataframe.DataFrameImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import us.lsi.tools.Preconditions;
import fp_Dataframe.DataFrame;

public class ExamenEntregaData {
	
	
	//Primero
	public static DataFrame emptyDataFrame(DataFrame df) {
      
        List<String> columNames = df.columNames();
        
        return DataFrameImpl.of(columNames, Collections.emptyList(), Collections.emptyList());
    }
	
	//Segundo
	
	public static DataFrame addDataFrame(DataFrame df1, DataFrame df2) {
        
        List<String> columNames1 = df1.columNames();
        List<String> columNames2 = df2.columNames();

        List<String> combinedColumNames = new ArrayList<>(columNames1);
        combinedColumNames.addAll(columNames2);

        List<List<String>> rows1 = df1.rows();
        List<List<String>> rows2 = df2.rows();

        List<List<String>> combinedRows = new ArrayList<>(rows1);
        combinedRows.addAll(rows2);

        return DataFrameImpl.of(combinedColumNames, combinedRows);
    }
	
	

	//Tercero
	public static DataFrame removeColumIndex(DataFrame df, int ci) {
        
        if (ci < 0 || ci >= df.columNumber()) {
            throw new IllegalArgumentException("El índice de columna especificado no es válido.");
        }
        
        List<String> columNames = new ArrayList<>(df.columNames());
        columNames.remove(ci);

        
        Map<String, Integer> columIndex = new HashMap<>();
        int newIndex = 0;
        for (String columnName : columNames) {
            columIndex.put(columnName, newIndex);
            newIndex++;
        }

        
        List<List<String>> rows = new ArrayList<>();
        for (List<String> row : df.rows()) {
            List<String> newRow = new ArrayList<>(row);
            newRow.remove(ci);
            rows.add(newRow);
        }

        return DataFrameImpl.of(columNames, columIndex, rows);
    }
	
	//Cuarto
	
	public static List<DataFrame> divideDataFrame(DataFrame df, int ci) {
	    Preconditions.checkArgument(ci > 0 && ci < df.columNumber(), "El valor de 'ci' debe estar entre 0 y el número de columnas del DataFrame");

	    List<DataFrame> dividedFrames = new ArrayList<>();

	  
	    List<String> columNames1 = df.columNames().subList(0, ci);
	    List<String> columNames2 = df.columNames().subList(ci + 1, df.columNumber());

	    List<List<String>> rows1 = df.rows().stream()
	            .map(row -> row.subList(0, ci))
	            .collect(Collectors.toList());

	    List<List<String>> rows2 = df.rows().stream()
	            .map(row -> row.subList(ci + 1, df.columNumber()))
	            .collect(Collectors.toList());

	    DataFrame frame1 = DataFrameImpl.of(columNames1, rows1);
	    DataFrame frame2 = DataFrameImpl.of(columNames2, rows2);

	    dividedFrames.add(frame1);
	    dividedFrames.add(frame2);

	    return dividedFrames;
	}
	
	
	//Creo los 'datas' para la prueba del ejercicio 2( y para el ejercicio 3)
	public static DataFrame DataFrame1() {
        
        List<String> columNames = List.of("A", "B", "C");
        List<List<String>> rows = List.of(
                List.of("1", "2", "3"),
                List.of("4", "5", "6"),
                List.of("7", "8", "9")
        );
        return DataFrameImpl.of(columNames, rows);
    }

    public static DataFrame DataFrame2() {
        
        List<String> columNames = List.of("D");
        List<List<String>> rows = List.of(
                List.of("z"),
                List.of("x"),
                List.of("c")
        );
        return DataFrameImpl.of(columNames, rows);
    }

	
	
	//Pruebas defensa
	public static void main(String[] args ) {
		
		 List<String> columnas = List.of("q", "w", "e", "r", "t");
	     List<List<String>> filas = List.of(
	                List.of("1", "2", "3", "4", "5"),
	                List.of("6", "7", "8", "9", "10"),
	                List.of("11", "12", "13", "14", "15")
	     );
	        
	        
	    //Ejemplo uso Ejercicio1 
	        
	    DataFrame ls = DataFrameImpl.of(columnas, filas);
	    DataFrame ejercicio1 = emptyDataFrame(ls); 
	    System.out.println(ejercicio1);
	    

		
		//Ejemplo uso Ejercicio2
	
	     
	    DataFrame df1 = DataFrame1();
	    DataFrame df2 = DataFrame2();

	         
	    DataFrame resultado = addDataFrame(df1, df2);

	        
	    System.out.println(resultado);
	     
		
		//Ejemplo uso Ejercicio 3
	    
	    DataFrame ld = DataFrame1();

        
        int ci = 1;
        DataFrame result = removeColumIndex(ld, ci);
        System.out.println(result);
	    
		
		//Ejemplo uso Ejercicio 4
		
        DataFrame algo = DataFrameImpl.of(columnas, filas);

        
        List<DataFrame> dividedFrames = divideDataFrame(algo, 2);
        	
        System.out.println("Primer DataFrame:");
        System.out.println(dividedFrames.get(0));

        System.out.println("Segundo DataFrame:");
        System.out.println(dividedFrames.get(1));
    
		
	}

}
