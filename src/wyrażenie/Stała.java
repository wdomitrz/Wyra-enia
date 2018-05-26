package wyrażenie;

import java.util.Map;
import java.util.HashMap;
import static wyrażenie.Utils.*;

/**
 *
 * @author witek
 */
public class Stała extends Wyrażenie {

	/* 
	 * Mapa pomocnicza, dzięki której dla każdej wartości x
	 * powstanie maksymalnie jedna stała(x)
	 */
	private static final Map<Float, Wyrażenie> istniejąceStałe = new HashMap<>();

	private float wartość;

	/*
	 * Konstruktor jest prywatny - tak jak w konstrukcji singletonu.
	 */
	private Stała(float wartość) {
		this.wartość = wartość;
	}

	/*
	 * Dostęp do stałych w pakiecie mam jedynie przez getter, a ogólnie przez
	 * klasę Utils
	 */
	static Wyrażenie getStała(float wartość) {
		if (!istniejąceStałe.containsKey(wartość)) {
			istniejąceStałe.put(wartość, new Stała(wartość));
		}
		return istniejąceStałe.get(wartość);
	}

	@Override
	public float wartość(float x) {
		return wartość;
	}

	@Override
	public Wyrażenie pochodna() {
		// Pochodna funkcji stałej to stała 0.
		return stała(0f);
	}

	@Override
	public String toString() {
		return "" + wartość;
	}
}
