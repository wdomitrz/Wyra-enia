package wyrażenie;

import static wyrażenie.Utils.*;

/**
 *
 * @author witek
 */
public class Odejmowanie extends NieŁączne {

	public static final String SYMBOL = "-";

	Odejmowanie(Wyrażenie lewe, Wyrażenie prawe) {
		super(SYMBOL, lewe, prawe);
	}

	@Override
	public float wartość(float p) {
		return lewe.wartość(p) - prawe.wartość(p);
	}

	@Override
	public Wyrażenie pochodna() {
		return odejmowanie(
			lewe.pochodna(),
			prawe.pochodna());
	}

	@Override
	public int priorytet() {
		// Odejmowanie ma taki sam priorytet jak dodawanie
		return 0;
	}
}
