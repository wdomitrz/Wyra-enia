package wyrażenie;

/**
 *
 * @author witek
 */

/*
 * Podklasą operatorów są operatory łączne stworzone w celu ułatwienia
 * ignorowania niepotrzebnych nawiasów.
 * Łączność oznacza, że:
 * a <op> b <op> c <op> = a <op> (b <op> c)
 */
public abstract class Łączny extends Operator {

	Łączny(String symbol, Wyrażenie lewe, Wyrażenie prawe) {
		super(symbol, lewe, prawe);
	}

	@Override
	public String toString() {
		return super.toString(true);
	}
}
