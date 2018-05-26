package wyrażenie;

import static wyrażenie.Utils.*;

/**
 *
 * @author witek
 */
public abstract class Funkcja extends Wyrażenie {

	private String symbol;
	protected Wyrażenie argument;

	// Każda funkcja ma swój symbol i jeden argument
	Funkcja(String symbol, Wyrażenie argument) {
		this.symbol = symbol;
		this.argument = argument;
	}

	@Override
	public String toString() {
		return symbol + "(" + argument.toString() + ")";
	}

	/*
	 * Funkcja posiada swoją prostą pochodną - df(x)/dx, której znajomość 
	 * umożliwia obliczenie pochodnej niezależnie od funkcji z wzoru
	 * na pochodną złożenia funkcji (reguły łańcuchowej)
	 * df(g(x))/dx = df(g(x))/dg(x) * dg(x)/dx
	 */
	protected abstract Wyrażenie prostaPochodna();

	/*
	 * Korzystając z reguły łańcuchowej podaję pochodną funkcji na podstawie jej
	 * prostej pochodnej niezależnie jaka to funkcjia
	 */
	@Override
	public Wyrażenie pochodna() {
		return mnożenie(
			prostaPochodna(),
			argument.pochodna());
	}
}
