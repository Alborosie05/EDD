package fp;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Calculator {


	/*
     * este metodo devuelve el Class del object que le pasamos
     */
	public static Class classTypeOf(Object x) {
		Class clase = x.getClass();
		return clase;
	}


	/*
     * devuelve una lista con los n números de la serie de fibonacci.
     */
	public static List<Integer> fibonacci(int n) {
		int num1 = 1;
		int num2 = 1;
		List<Integer> numFibonacci = new ArrayList<Integer>();
		numFibonacci.add(num1);
		numFibonacci.add(num2);
		int i = 0;
		while (i <= n - 3) {
			numFibonacci.add(numFibonacci.get(i) + numFibonacci.get(i + 1));
			i++;
		}
		return numFibonacci;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		int[] numeros;
		List<Integer> numListas = new ArrayList();
		int numero = number - step;
		int i = 0;
		while (numero > 0) {
			numListas.add(numero);
			numero -= step;
			i++;
		}
		numeros = new int[i];
		for (int j = 0; j < numeros.length; j++) {
			numeros[j] = numListas.get(j);
		}
		return numeros;
		}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		List<Integer> div = new ArrayList<Integer>();
		int divisores[] = null;
		if (!positiveNumber(n)) {
			int cont = 0;
			for (int i = n; i >= 1; i--) {
				if (n % i == 0) {
					div.add(i);
					cont++;
				}
			}

			divisores = new int[cont];
			for (int i = 0; i < cont; i++) {
				divisores[i] = div.get(i);
			}
		}


		return divisores;
	}

	public static boolean positiveNumber(int n) {
		if (n == 0) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		if (cadena == null)
			return false;
		else {
			String sinCaracteresEnMinusculas = quitarCaracteresEspecialesYponerAMinusculas(cadena);
			
			Boolean palindromo = comprobarPalindromo(sinCaracteresEnMinusculas);

			return palindromo;

		}
	}

	public static String quitarCaracteresEspecialesYponerAMinusculas(String cadena) {
		String caracteresEspeciales = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ:;-_,.?¿¡!·";
		String normales = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC           ";
		String cadenaMinusculas = cadena.toLowerCase();
		for (int i = 0; i < caracteresEspeciales.length(); i++) {
			cadenaMinusculas = cadenaMinusculas.replace(caracteresEspeciales.charAt(i), normales.charAt(i));
		}
		return cadenaMinusculas;
	}

	public static Boolean comprobarPalindromo(String sinCaracteresEnMinusculas) {
		String invertida = "";
		sinCaracteresEnMinusculas = sinCaracteresEnMinusculas.replace(" ", "");
		for (int i = sinCaracteresEnMinusculas.length() - 1; i >= 0; i--)
			invertida += sinCaracteresEnMinusculas.charAt(i);
		if (sinCaracteresEnMinusculas.equals(invertida))
			return true;
		else
			return false;
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		String numero = "";
		String cero = "Cero";
		String unidades[] = { "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve" };
		String decenas[] = { "Diez", "Veinte", "Treinta", "Cuarenta", "Cincuenta", "Sesenta", "Setenta", "Ochenta",
				"Noventa" };
		if (n == 0) {
			numero += cero;
		} else if (n < 10) {
			numero += unidades[n - 1];
		} else if (n % 10 == 0) {
			numero += decenas[(n / 10) - 1];
		} else {
			int unidad = n % 10;
			int decena = n / 10;
			numero = decenas[decena - 1] + " y " + unidades[unidad - 1];
		}
		return numero;
		
	}


	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		if (!stringIsNull(fecha)) {
			GregorianCalendar calendar = new GregorianCalendar();
			int anio = anioParseado(fecha);
			if (calendar.isLeapYear(anio)) {
			return true;
		} else {
			return false;
		}
		} else {
			return false;
		}
	}

	// comprueba que la fecha no este vacia
	public static boolean stringIsNull(String fecha) {
		if (fecha != "") {
			return false;
		} else {
			return true;
		}
	}

	// extrae el año de la fecha y lo parsea a tipo int
	public static int anioParseado(String fecha) {
		fecha = fecha.substring(6, 10);

		int anio = Integer.parseInt(fecha);
		return anio;
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		if (!stringIsNull(date)) {
			if (formatOfDate(date)) {
				return true;
			}else {
				return false;
			}

		} else {
			return false;
		}

	}
	
	// comprobamos si el formato de la fecha es valido
	public static boolean formatOfDate(String date) {
		if (date.length() == 10) {
			int dia = Integer.parseInt(date.substring(0, 2));
			int mes = Integer.parseInt(date.substring(3, 5));
			int anyo = Integer.parseInt(date.substring(6, date.length()));
			if ((dia <= 31 && dia >= 1) && (mes <= 12 && mes >= 1) && (anyo > 0 && anyo <= 9999)
				&& (date.charAt(2) == '-' && date.charAt(5) == '-')) {
			return true;
		} else {
			return false;
		}
		} else {
			return false;
		}
	}



}
