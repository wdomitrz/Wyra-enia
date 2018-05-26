package wyrażenie;

/**
 *
 * @author witek
 */

/*
 * Podklasą operatorów są operatory niełączne stworzone w celu 
 * nieusuwania wymaganych do zachowania znaczenia wyrażenia nawiasów.
 * Łączność oznacza, że:
 * a <op> b <op> c <op> = a <op> (b <op> c)
 */
public abstract class NieŁączne extends Operator {

	NieŁączne(String symbol, Wyrażenie lewe, Wyrażenie prawe) {
		super(symbol, lewe, prawe);
	}

	@Override
	public String toString() {
		return super.toString(false);
	}
}
