package wyrażenie;

/**
 *
 * @author witek
 */

/*
 * Klasa Utils ułatwia zapis wyrażeń - zamias new Mnożenie(...) można napisać
 * mnożenie(...), co przy dłuższym kodzie jest bardzo pomocne.
 *
 * Ponieważ domyślnie tworzenie nowych wyrażeń będzie się odbywać z pomocą 
 * klasy Utils, to modyfikatory konstruktorów są pakietowe
 */
public class Utils {

	public static Wyrażenie stała(float wartość) {
		return Stała.getStała(wartość);
	}

	public static Wyrażenie zmienna() {
		return new Zmienna();
	}

	public static Wyrażenie cosinus(Wyrażenie argument) {
		return new Cosinus(argument);
	}

	public static Wyrażenie sinus(Wyrażenie argument) {
		return new Sinus(argument);
	}

	public static Wyrażenie logarytm(Wyrażenie argument) {
		return new Logarytm(argument);
	}

	public static Wyrażenie wykładnicza(Wyrażenie argument) {
		return new Wykładnicza(argument);
	}

	public static Wyrażenie dodawanie(Wyrażenie lewe, Wyrażenie prawe) {
		return new Dodawanie(lewe, prawe);
	}

	public static Wyrażenie odejmowanie(Wyrażenie lewe, Wyrażenie prawe) {
		return new Odejmowanie(lewe, prawe);
	}

	public static Wyrażenie mnożenie(Wyrażenie lewe, Wyrażenie prawe) {
		return new Mnożenie(lewe, prawe);
	}

	public static Wyrażenie dzielenie(Wyrażenie lewe, Wyrażenie prawe) {
		return new Dzielenie(lewe, prawe);
	}
}
