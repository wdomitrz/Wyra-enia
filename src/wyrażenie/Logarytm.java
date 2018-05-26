package wyrażenie;

import static wyrażenie.Utils.*;

/**
 *
 * @author witek
 */
public class Logarytm extends Funkcja {

	public static final String SYMBOL = "ln";

	Logarytm(Wyrażenie argument) {
		super(SYMBOL, argument);
	}

	@Override
	public float wartość(float p) {
		return (float) Math.log(argument.wartość(p));
	}

	@Override
	public Wyrażenie prostaPochodna() {
		return dzielenie(
			stała(1),
			sinus(argument));
	}
}
