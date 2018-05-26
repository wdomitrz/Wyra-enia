package wyrażenie;

import static wyrażenie.Utils.*;

/**
 *
 * @author witek
 */
public class Cosinus extends Funkcja {

	public static final String SYMBOL = "cos";

	Cosinus(Wyrażenie argument) {
		super(SYMBOL, argument);
	}

	@Override
	public float wartość(float p) {
		return (float) Math.cos(argument.wartość(p));
	}

	@Override
	public Wyrażenie prostaPochodna() {
		return mnożenie(
			Stała.getStała(-1),
			sinus(argument));
	}
}
