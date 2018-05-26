package wyrażenie;

import static wyrażenie.Utils.*;

/**
 *
 * @author witek
 */
public class Dodawanie extends Łączny {

	public static final String SYMBOL = "+";

	Dodawanie(Wyrażenie lewe, Wyrażenie prawe) {
		super(SYMBOL, lewe, prawe);
	}

	@Override
	public float wartość(float p) {
		return lewe.wartość(p) + prawe.wartość(p);
	}

	@Override
	public Wyrażenie pochodna() {
		return dodawanie(
			lewe.pochodna(),
			prawe.pochodna());
	}

	@Override
	public int priorytet() {
		return 0;
	}
}
