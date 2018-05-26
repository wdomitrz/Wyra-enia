package wyrażenie;

import static wyrażenie.Utils.*;

/**
 *
 * @author witek
 */
public class Sinus extends Funkcja {

	public static final String SYMBOL = "sin";

	Sinus(Wyrażenie argument) {
		super(SYMBOL, argument);
	}

	@Override
	public float wartość(float p) {
		return (float) Math.sin(argument.wartość(p));
	}

	@Override
	public Wyrażenie prostaPochodna() {
		return cosinus(argument);
	}
}
