package wyrażenie;

import static wyrażenie.Utils.*;

/**
 *
 * @author witek
 */
public class Dzielenie extends NieŁączne {

	public static final String SYMBOL = "/";

	Dzielenie(Wyrażenie lewe, Wyrażenie prawe) {
		super(SYMBOL, lewe, prawe);
	}

	@Override
	public float wartość(float p) {
		return lewe.wartość(p) / prawe.wartość(p);
	}

	@Override
	public Wyrażenie pochodna() {
		return dzielenie(
			odejmowanie(
				mnożenie(lewe.pochodna(), prawe),
				mnożenie(lewe, prawe.pochodna())),
			mnożenie(prawe, prawe));
	}

	@Override
	public int priorytet() {
		// Dzielenie ma taki sam priorytet jak mnożenie
		return 10;
	}
}
