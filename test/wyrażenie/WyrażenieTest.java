package wyrażenie;

import org.junit.Test;
import static org.junit.Assert.*;
import static wyrażenie.Utils.*;

/**
 *
 * @author witek
 */
public class WyrażenieTest {

	@Test
	public void testWartość() {
		System.out.println("warto\u015b\u0107");
		float p;
		Wyrażenie instance;
		float expResult;
		float result;

		p = 1.0F;
		instance = INSTANCES[0];
		expResult = 1.0F;
		result = instance.wartość(p);
		assertEquals(expResult, result, 0.0);

		p = -3.14F;
		instance = INSTANCES[1];
		expResult = (float) Math.sin(2.0F + p);
		result = instance.wartość(p);
		assertEquals(expResult, result, 0.0);

		p = 1.0F;
		instance = INSTANCES[2];
		expResult = (float) (((float) Math.log(p)) / ((float) Math.exp(p * 7.0F)));
		result = instance.wartość(p);
		assertEquals(expResult, result, 0.0);

		p = 123.0F;
		instance = INSTANCES[3];
		expResult = (float) (((float) Math.cos(p / p)) - ((float) Math.cos(p * p)));
		result = instance.wartość(p);
		assertEquals(expResult, result, 0.0);

		p = 4.0F;
		instance = INSTANCES[4];
		expResult
			= (p / 2.0F) / (6.1F / p)
			+ (p / 2.0F) - (6.1F + p)
			+ (p - 2.0F) - (6.1F - p)
			+ (p * 2.0F) + (6.1F + p);
		result = instance.wartość(p);
		assertEquals(expResult, result, 0.0);
	}

	@Test
	public void testToString() {
		System.out.println("toString");
		Wyrażenie instance;
		String expResult;
		String result;

		instance = INSTANCES[0];
		expResult = "1.0";
		result = instance.toString();
		assertEquals(expResult, result);

		instance = INSTANCES[1];
		expResult = "sin(2.0+x)";
		result = instance.toString();
		assertEquals(expResult, result);

		instance = INSTANCES[2];
		expResult = "ln(x)/exp(x*7.0)";
		result = instance.toString();
		assertEquals(expResult, result);

		instance = INSTANCES[3];
		expResult = "cos(x/x)-cos(x*x)";
		result = instance.toString();
		assertEquals(expResult, result);

		instance = INSTANCES[4];
		expResult = "x/2.0/(6.1/x)+x/2.0-(6.1+x)+x-2.0-(6.1-x)+x*2.0+6.1+x";
		result = instance.toString();
		assertEquals(expResult, result);
	}

	@Test
	public void testPochodna() {
		System.out.println("pochodna");
		// Ręcznie zapisałem pochodne jako Stringi
		Wyrażenie instance;
		String expResult;
		String result;

		instance = INSTANCES[0];
		expResult = "0.0";
		result = instance.pochodna().toString();
		assertEquals(expResult, result);

		instance = INSTANCES[1];
		expResult = "cos(2.0+x)*(0.0+1.0)";
		result = instance.pochodna().toString();
		assertEquals(expResult, result);

		instance = INSTANCES[2];
		expResult = "(1.0/sin(x)*1.0*exp(x*7.0)-ln(x)*exp(x*7.0)*(1.0*7.0+x*0.0))/(exp(x*7.0)*exp(x*7.0))";
		result = instance.pochodna().toString();
		assertEquals(expResult, result);

		instance = INSTANCES[3];
		expResult = "-1.0*sin(x/x)*(1.0*x-x*1.0)/(x*x)--1.0*sin(x*x)*(1.0*x+x*1.0)";
		result = instance.pochodna().toString();
		assertEquals(expResult, result);

		instance = INSTANCES[4];
		expResult = "((1.0*2.0-x*0.0)/(2.0*2.0)*6.1/x-x/2.0*(0.0*x-6.1*1.0)/(x*x))/(6.1/x*6.1/x)+(1.0*2.0-x*0.0)/(2.0*2.0)-(0.0+1.0)+1.0-0.0-(0.0-1.0)+1.0*2.0+x*0.0+0.0+1.0";
		result = instance.pochodna().toString();
		assertEquals(expResult, result);
	}

	@Test
	public void testCałka() {
		System.out.println("całka");
		// Za pomocą komputera policzyłem całki metodą taką jak w Wyrażeniu
		Wyrażenie instance;
		float expResult;
		float result;
		float b, e;

		b = -1.0F;
		e = 2.0F;

		instance = INSTANCES[0];
		expResult = 3.0358765F;
		result = instance.całka(b, e);
		assertEquals(expResult, result, 0.0);

		instance = INSTANCES[1];
		expResult = 1.1940408F;
		result = instance.całka(b, e);
		assertEquals(expResult, result, 0.0);

		b = 0.00001F;
		e = 5.0F;
		instance = INSTANCES[2];
		expResult = -0.3601198F;
		result = instance.całka(b, e);
		assertEquals(expResult, result, 0.0);

		b = -1.0F;
		e = 2.0F;

		instance = INSTANCES[3];
		expResult = 0.26109618F;
		result = instance.całka(b, e);
		assertEquals(expResult, result, 0.0);

		instance = INSTANCES[4];
		expResult = -17.353384F;
		result = instance.całka(b, e);
		assertEquals(expResult, result, 0.0);
	}

	@Test
	public void testPriorytet() {
		System.out.println("priorytet");
		Wyrażenie instance;
		int expResult;
		int result;

		instance = INSTANCES[0];
		expResult = Integer.MAX_VALUE;
		result = instance.priorytet();
		assertEquals(expResult, result, 0.0);

		instance = INSTANCES[1];
		expResult = Integer.MAX_VALUE;
		result = instance.priorytet();
		assertEquals(expResult, result, 0.0);

		instance = INSTANCES[2];
		expResult = 10;
		result = instance.priorytet();
		assertEquals(expResult, result, 0.0);

		instance = INSTANCES[3];
		expResult = 0;
		result = instance.priorytet();
		assertEquals(expResult, result, 0.0);

		instance = INSTANCES[4];
		expResult = 0;
		result = instance.priorytet();
		assertEquals(expResult, result, 0.0);
	}

	private static final Wyrażenie[] INSTANCES = {
		stała(1.0F),
		
		sinus(
			dodawanie(
				stała(2.0F),
				zmienna()
			)
		),
		
		dzielenie(
			logarytm(zmienna()),
			wykładnicza(
				mnożenie(
					zmienna(),
					stała(7.0F)
				)
			)
		),
		
		odejmowanie(
			cosinus(
				dzielenie(
					zmienna(),
					zmienna()
				)
			),
			cosinus(
				mnożenie(
					zmienna(),
					zmienna()
				)
			)
		),
		
		dodawanie(
			dodawanie(
				dzielenie(
					dzielenie(
						zmienna(), 
						stała(2.0F)
					), 
					dzielenie(
						stała(6.1F), 
						zmienna()
					)
				),
				odejmowanie(
					dzielenie(
						zmienna(), 
						stała(2.0F)
					), 
					dodawanie(
						stała(6.1F), 
						zmienna()
					)
				)
			),
			dodawanie(
				odejmowanie(
					odejmowanie(
						zmienna(), 
						stała(2.0F)
					), 
					odejmowanie(
						stała(6.1F), 
						zmienna()
					)
				),
				dodawanie(
					mnożenie(
						zmienna(), 
						stała(2.0F)
					), 
					dodawanie(
						stała(6.1F), 
						zmienna()
					)
				)
			)
		)
	};
}
