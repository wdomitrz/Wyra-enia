package wyrażenie;

/**
 *
 * @author witek
 */

/*
 * Operatory to funkcje dwuargumentowe. Każdy operator ma symbol i dwa argumenty
 */
public abstract class Operator extends Wyrażenie {

	private final String symbol;
	protected Wyrażenie lewe, prawe;

	Operator(String symbol, Wyrażenie lewe, Wyrażenie prawe) {
		this.symbol = symbol;
		this.lewe = lewe;
		this.prawe = prawe;
	}

	@Override
	/*
	 * Każdy operator musi mieć na nowo zdefiniowany priorytet
	 */
	public abstract int priorytet();

	/*
	 * Dla danego operatora możemy wypisać go z lub bez nawiasów na podstawie
	 * jego priorytetu i łączności.
	 */
	String toString(Boolean czyŁączne) {
		String lewaStrona, prawaStrona;
		// Zależnie od priorytetu lewego wyrażenia stawiamy wokół niego nawiasy, lub nie
		if (lewe.priorytet() >= priorytet()) {
			lewaStrona = lewe.toString();
		} else {
			lewaStrona = "(" + lewe.toString() + ")";
		}
		// Nawiasy w okół prawego wyrażenia stawiamy zależnie od priorytetu, a w przypadku
		// wątpliwości - równych priorytetów - sptawdzamy łączność.
		if (prawe.priorytet() > priorytet() || (prawe.priorytet() == priorytet() && czyŁączne)) {
			prawaStrona = prawe.toString();
		} else {
			prawaStrona = "(" + prawe.toString() + ")";
		}
		return lewaStrona + symbol + prawaStrona;
	}
}
