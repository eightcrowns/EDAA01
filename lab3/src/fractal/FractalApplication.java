package fractal;

import koch.Koch;
import mountain.*;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = {
				new Koch(300),
				new Mountain(new Point(200, 400), new Point(350, 200), new Point(400, 450)),
				new RandomMountain(new Point(200, 400), new Point(350, 200), new Point(400, 450), 10)};
	    new FractalView(fractals, "Fraktaler");
	}

}
