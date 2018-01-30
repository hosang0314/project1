package an;

import an.Frame1;
import an.Frame2;
import an.Frame3;
import an.Frame4;
import an.Frame5;
import an.Frame6;
import an.Frame7;

public class app {
	public static void login() {
		Frame3 f3 = new Frame3();
		f3.makeUi();		
	}

	public static void join() {		
		Frame2 f2 = new Frame2();
		f2.makeUi();		
	}

	public static void main(String[] args) {
		Frame1 f1 = new Frame1();
		f1.makeUi();
	}

}
