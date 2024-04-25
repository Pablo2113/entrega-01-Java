package fp_Dataframe;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import us.lsi.tools.Enumerate;
import us.lsi.tools.List2;
import us.lsi.tools.Stream2;
import java.util.ArrayList;



public class DataFrameImpl_de_ayuda implements DataFrame {
	// --------------------
	// Atributos
	private List<String> columNames; // Nombres de las columnas
	private Map<String,Integer> columIndex; // Dado el nombre de una columna indica el índice
	private List<List<String>> rows; // Lista de las filas
	// --------------------
	// Constructores
	private DataFrameImpl_de_ayuda(List<String>columNames, Map<String, Integer> columIndex, List<List<String>> rows) {


		// Se inicializan los atributos, pero se asignan copias de los parámetros y no los parámetros en sí mismos
		// TODO
	}
	// --------------------
	// Métodos de factoría
	private static DataFrameImpl_de_ayuda of(List<String> columNames,Map<String,Integer> columIndex,List<List<String>> rows) {
		// Se calcula a partir del constructor de manera directa
		// TODO
		return null;
	}
	public static DataFrameImpl_de_ayuda of(Map<String,List<String>> data) {
		// Se deriva columNames a partir de data y se llama al método anterior
		// TODO
		return null;
	}
	public static DataFrameImpl_de_ayuda of(Map<String,List<String>> data, List<String> columNames) {
		// Se debe llamar al método DataFrameImpl.of(columNames,columIndex,rows)
		// columNames y columIndex se calculan recorriendo el diccionario data
		// No olvide comprobar que las claves de data deben coincidir con columNames
		//TODO
		return null;
    }
	public static DataFrameImpl_de_ayuda parse(String file) {
		// Se utiliza el método mapDeCsv de File2 (ver la librería de referencia) y se llama a uno de los métodos anteriores
		// TODO
		return null;
    }
	public static DataFrameImpl_de_ayuda parse(String file, List<String> columNames) {
		// Se utiliza el método mapDeCsv de File2 y se llama a uno de los métodos anteriores 
		// TODO
		return null;
    }
	public static DataFrameImpl_de_ayuda of(List<String> columNames, List<List<String>> rows) {
		//
		Map<String,Integer> columIndex = new HashMap<>();
		IntStream.range(0,columNames.size()).forEach(i->columIndex.put(columNames.get(i),i));
        return DataFrameImpl_de_ayuda.of(columNames,columIndex,rows);
    }
	// --------------------
	// Métodos estáticos auxiliares: 
	// Método auxiliar para la propiedad columAllDifferent
	public static Boolean allDifferent(List<String> values) {
		Integer n = values.size();
		Integer m = values.stream().collect(Collectors.toSet()).size();
        return n.equals(m);
    }
	// Método auxiliar para la propiedad groupBy
	public static String string(Object r) {
		String s = null;
		if(r instanceof LocalDate) {
			LocalDate r1 = (LocalDate) r;
			s = r1.format(DataFrame.dateFormat());
		} if(r instanceof LocalTime) {
			LocalTime r1 = (LocalTime) r;
			s = r1.format(DataFrame.timeFormat());
		} if(r instanceof LocalDateTime) {
			LocalDateTime r1 = (LocalDateTime) r;
			s = r1.format(DataFrame.dateTimeFormat());
		} else if(r instanceof Double) {
			s = String.format("%.2f",r);
		} else if(r instanceof Integer) {
			s = String.format("%d",r);
		} else {
			s = r.toString();
		}
		return s;
	}
	// Método de utilidad (no se llama en ningún otro método, se ofrece con el tipo)
	@SuppressWarnings("unchecked")
	public static <R> R parse(String text, Class<R> type) {
		Object r = null;
		if(type.equals(LocalDate.class)) {
			r = LocalDate.parse(text,DataFrame.dateFormat());
		} else if(type.equals(LocalTime.class)) {
			r = LocalTime.parse(text,DataFrame.timeFormat());
		} else if(type.equals(LocalDateTime.class)) {
			r = LocalDateTime.parse(text,DataFrame.dateTimeFormat());
		} else if(type.equals(Double.class)) {
			r = Double.parseDouble(text);
		} else if(type.equals(Integer.class)) {
			r = Integer.parseInt(text);
		} else {
			r = text;
		}
		return (R) r;
	}
	// --------------------
	// Métodos de las propiedades
	@Override
	public List<String> columNames() {
		return new ArrayList<>(this.columNames);
		// Devuelve una copia del atributo correspondiente 
		// TODO
	}
	@Override
	public Integer columNumber() {
		return this.columNames.size();
		// Se calcula a partir del atributo columNames
		// TODO
	}
	@Override
	public List<String> colum(String name) {
		List<String> r = new ArrayList<>(); 
		Integer Index = this.columIndex.get(name);
		
		for(List<String> fila : this.rows) {
			if(Index != null && Index < rows.size()) {
				r.add(fila.get(Index));
			} 	else {
				r.add(null);
			}
			return r;
			}
	}
		// Se calcula a partir del atributo columIndex
		// TODO
	
	public List<String> colum(Integer index) {
		List<String> r = new ArrayList<>();
		for(List<String> fila : this.rows) {
			if(index != null && index < this.rows.size()) {
				r.add(fila.get(index));
			} else {
				r.add(null);
			}
			return r;
		}
	}
		// Se calcula a partir del atributo rows
		// TODO
		
	@Override
	public <R> List<R> colum(String name, Class<R> type){
		return this.colum(name).stream().map(x->DataFrame.parse(x,type)).toList();
	}
	// ¿Podrías explicar qué significa Class<R> type) como parámetro de entrada? // Es un clase genérica la cual
	
	
	@Override
    public <R> List<R> colum(Integer index, Class<R> type){
		return this.colum(index).stream().map(x->DataFrame.parse(x,type)).toList();
		
		// La programación es muy parecida al método anterior. Trata de reproducirla
		// TODO
		
	}
	@Override
	public Boolean columAllDifferent(String name) {
		
		// Se calcula utilizando el método estático auxiliar allDifferent
		// TODO
	}
	
	@Override
	public String propertie(List<String> row, String colum) {
		// Se calcula a partir del atributo row utilizando las propiedades de los diccionarios
		// TODO
		return null;
	}
	@Override
	public <R> R propertie(List<String> row, String colum, Class<R> type) {
		//
		String text = row.get(this.columIndex.get(colum));
		return DataFrame.parse(text, type);
	}
	@Override
	public String cell(Integer row, String colum) {
		// Se calcula con los atributos rows y columIndex y los valores enteros dados como parámetros
		// Es decir, se da una fila y una columna y se cruzan en una casilla en concreto
		// TODO
		return null;
	}
	@Override
	public String cell(Integer row, Integer colum) {
		// Se calcula de manera muy parecida al método anterior
		// TODO
		return null;
	}
	@Override
	public String cell(String row,String colum, String propertie) {
		// Se calcula de manera muy parecida al método anterior
		// TODO
		return null;
	}
	@Override
	public Integer rowNumber() {
		// Se calcula a partir del atributo rows
		// TODO
		return null;
	}
	@Override
	public List<String> row(Integer i) {
		// Se calcula a partir del atributo rows
		// TODO
		return null;
	}
	@Override
	public List<String> row(String row, String colum) {
		// Debe comprobar que la columna no existe previamente en el Dataframe: 
		// para ello realice un chequeo usando la utilidad allDifferent
		// Se calcula a partir del atributo rows
		// TODO
		return null;
	}
	@Override
	public List<List<String>> rows() {
		//
		return this.rows.stream().<List<String>>map(r->r.stream().toList()).toList();
	}
	@Override
	public DataFrame head() {
		// Se calcula a partir del método head: por defecto muestra cinco fillas
		// TODO
		return null;
	}
	@Override
	public DataFrame head(Integer n) {
		// Muestra las n primeras filas del Dataframe: se calcula usando la propiedad subList
		//
		List<String> columNames = new ArrayList<>(this.columNames);
		Map<String,Integer> columIndex = new HashMap<>(this.columIndex);
		List<List<String>> rows = new ArrayList<>(this.rows);
		return DataFrameImpl_de_ayuda.of(columNames,columIndex,rows.subList(0, n));
	}
	@Override
	public DataFrame tail() {
		// Análogo al método head
		return this.tail(5);
	}
	@Override
	public DataFrame tail(Integer n) {
		// Análogo al método head
		// TODO
		return null;
	}
	@Override
	public DataFrame slice(Integer n, Integer m) {
		// Análogo al método head
		// TODO
		return null;
	}
	@Override
	public DataFrame filter(Predicate<List<String>> p) {
		// Se calcula de manera análoga al método head pero realizando un filtrado
		// TODO
		return null;
	}
	@Override
	public <E extends Comparable<? super E>> DataFrame sortBy(Function<List<String>, E> f, Boolean reverse) {
		//
		List<String> columNames = new ArrayList<>(this.columNames);
		Map<String,Integer> columIndex = new HashMap<>(this.columIndex);
		List<List<String>> rows = new ArrayList<>(this.rows);
		Comparator<List<String>> cmp = reverse?Comparator.comparing(f).reversed():Comparator.comparing(f);
		Collections.sort(rows,cmp);
		return DataFrameImpl_de_ayuda.of(columNames,columIndex,rows);
	}
	private Set<Integer> indexes(List<String> columNames){
		//
		return columNames.stream().map(cn->this.columIndex.get(cn)).collect(Collectors.toSet());
	}
	private List<String> select(List<String> ls, Set<Integer> sl){
		//
		return IntStream.range(0, ls.size()).boxed()
				.filter(i->sl.contains(i))
				.map(i->ls.get(i))
				.toList();
	}
	@Override
	public <R> DataFrame groupBy(List<String> columNames, String newColumn, BinaryOperator<R> op,
			Function<List<String>, R> value) {
		//
		Function<List<String>,List<String>> key = ls->this.select(ls,this.indexes(columNames));
		Map<List<String>,R> g = Stream2.groupingReduce(this.rows.stream(),key,op,value);
		DataFrame r = DataFrame.of(columNames,g.keySet().stream().toList());		
		r = r.addColum(newColumn,g.values().stream().map(x->DataFrameImpl_de_ayuda.string(x)).toList());
		return r;
	}
	@Override
	public DataFrame addColum(String newColum, List<String> datos) {
		//
		List<String> columNames = new ArrayList<>(this.columNames);
		columNames.add(newColum);
		Map<String,Integer> columIndex = new HashMap<>(this.columIndex);
		columIndex.put(newColum,this.columNumber()+1);
		List<List<String>> rows = new ArrayList<>(this.rows);
		Integer nr = this.rowNumber();
		List<List<String>> rn = IntStream.range(0, nr).boxed()
				.map(r->List2.concat(rows.get(r),List.of(datos.get(r))))
				.toList();
		return DataFrameImpl_de_ayuda.of(columNames,columIndex,rn);
	}
	@Override
	public DataFrame addCalculatedColum(String newColum, Function<List<String>, String> f) {
		// Se calcula a partir del método anterior obteniendo la columna a añadir a través del atributo row y el parámetro f
		// TODO
		return null;
	}
	@Override
	public DataFrame removeColum(String colum) {
		//
		Integer c = this.columIndex.get(colum);
		List<String> columNames = new ArrayList<>(this.columNames);
		columNames.remove(colum);
		Map<String,Integer> columIndex = new HashMap<>();
		IntStream.range(0,columNames.size()).forEach(i->columIndex.put(columNames.get(i),i));		
		List<List<String>> rows = new ArrayList<>(this.rows);
		List<List<String>> rn = rows.stream()
				.map(r->IntStream.range(0, this.columNumber()).boxed().filter(i->i != c).map(i->r.get(i)).toList())
				.toList();
		return DataFrameImpl_de_ayuda.of(columNames,columIndex,rn);
	}
	// --------------------
	// Métodos adicionales: redefinidos de Object
	@Override
	public String toString() {
		//
		Integer t = 13;
		String r = this.format(" ",this.columNames(),t);
		String line = this.line(this.columNames().size()+1, t);
		String r3 = Stream2.enumerate(this.rows.stream()).map(x->this.format(x,t))
				.collect(Collectors.joining("\n", r+"\n"+line+"\n", "\n"));
		return r3;
	}
	private String format(String propertie, List<String> ls, Integer n) {
		//
		List<String> nls = new ArrayList<String>();
		nls.add(propertie);
		nls.addAll(ls);
		String fmt = "%"+n+"s";
		return nls.stream().map(c->String.format(fmt,c)).collect(Collectors.joining("|","|","|"));
	}
	private String format(Enumerate<List<String>> e, Integer n) {
		//
		return this.format(e.counter().toString(),e.value(),n);
	}
	private String line(Integer m, Integer n) {
		//
		String s = IntStream.range(0, n).boxed().map(i->"_").collect(Collectors.joining(""));
		return IntStream.range(0, m).boxed().map(i->s).collect(Collectors.joining("|","|","|"));
	}
	//

}
