package wyrażenie;

/**
 *
 * @author witek
 */
// Nadklasa wszystkich klas - wyrażeń
public abstract class Wyrażenie {

	// Liczba kawałków do całkowania metodą przybliżoną
	public static final int KAWAŁKI_DO_CAŁKI = 1000000;

	public abstract float wartość(float p);

	public abstract Wyrażenie pochodna();

	@Override
	public abstract String toString();

	/*
	 * Przybliżone całkowanie jest niezaleleżne od 
	 * niczego oprócz wartości wyrażenia w punkcie.
	 */
	public float całka(float x, float y) {
		float dx = (y - x) / KAWAŁKI_DO_CAŁKI;
		float war = 0;
		for (float b = x; b < y; b += dx) {
			war += wartość(b) * dx;
		}
		return war;
	}

	/*
	 * Domyślny priorytet to priorytet maksymalny - jest on przedefiniowany w 
	 * operatorach
	 */
	public int priorytet() {
		return Integer.MAX_VALUE;
	}
}
