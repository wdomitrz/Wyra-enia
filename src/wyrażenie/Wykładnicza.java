package wyrażenie;

import static wyrażenie.Utils.*;

/**
 *
 * @author witek
 */
public class Wykładnicza extends Funkcja {

	public static final String SYMBOL = "exp";

	Wykładnicza(Wyrażenie argument) {
		super(SYMBOL, argument);
	}

	@Override
	public float wartość(float p) {
		return (float) Math.exp(argument.wartość(p));
	}

	@Override
	public Wyrażenie prostaPochodna() {
		return wykładnicza(argument);
	}
}
