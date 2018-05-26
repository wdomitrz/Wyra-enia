package wyrażenie;

import static wyrażenie.Utils.*;

/**
 *
 * @author witek
 */
public class Zmienna extends Wyrażenie {

	@Override
	public float wartość(float x) {
		return x;
	}

	@Override
	public Wyrażenie pochodna() {
		// Pochodna funkcji f(x) = x to 1.
		return stała(1f);
	}

	@Override
	public String toString() {
		return "x";
	}
}
