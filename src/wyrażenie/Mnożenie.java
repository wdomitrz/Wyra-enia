package wyrażenie;

import static wyrażenie.Utils.*;

/**
 *
 * @author witek
 */
public class Mnożenie extends Łączny {

	public static final String SYMBOL = "*";

	Mnożenie(Wyrażenie lewe, Wyrażenie prawe) {
		super(SYMBOL, lewe, prawe);
	}

	@Override
	public float wartość(float p) {
		return lewe.wartość(p) * prawe.wartość(p);
	}

	@Override
	public Wyrażenie pochodna() {
		return dodawanie(
			mnożenie(lewe.pochodna(), prawe),
			mnożenie(lewe, prawe.pochodna()));
	}

	@Override
	public int priorytet() {
		return 10;
	}
}
