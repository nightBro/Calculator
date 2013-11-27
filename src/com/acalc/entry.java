package com.acalc;

public class entry {
	double a = 0;
	double b = 0;
	double result = 0;
	String cString = "";
	int minusPos = 1;

	public entry(double a, double b, double result, String cString) {
		super();
		this.a = a;
		this.b = b;
		this.result = result;
		this.cString = cString;
	}

	public entry() {
		super();
	}

	public void calculate() {
		double c = 0;
		switch (cString.charAt(0)) {
		case '/':
			if (b != 0) {
				c = a / b;
			}
			break;
		case '*':
			c = a * b;
			break;
		case '+':
			c = a + b;
			break;
		case '-':
			c = a - b;
			break;
		case 's':
			c = Math.sqrt(a);
			break;
		case '^':
			c = Math.pow(a, b);
			break;
		}
		this.result = c;

	}

	@Override
	public String toString() {
		String rString = "";
		if (a != 0 && b == 0 && result == 0 && cString.equals("")) {
			rString = (Double.toString(a));
		}
		if (a != 0 && b == 0 && result == 0) {
			if(cString.equals("s")){
				rString = (" ________"+ "\n" + "/"+Double.toString(a) + " ");
			}else{
			rString = (Double.toString(a) + " " + cString);
			}
		}
		if (a != 0 && b == 0 && result != 0) {
			rString = ("  ________"+ "\n" + "/"+Double.toString(a) + " " + "\n    " + " = " + Double.toString(result));
		}
		if (a != 0 && b != 0 && result == 0) {
			rString = (Double.toString(a) + " " +cString + " " + Double.toString(b));
		}
		if (a != 0 && b != 0 && result != 0) {
			rString = (Double.toString(a) + " " + cString + " " + Double.toString(b)+ "\n    " + " = " + Double.toString(result));
		}
		return rString;
	}

	public void addNumber(int numb, int entryPos, boolean pointSet) {
		if (!pointSet) {
			if (entryPos == 1) {
				a = (a * 10) + numb;
			} else {
				b = (b * 10) + numb;
			}
		}
		if (pointSet) {
			if (entryPos == 1) {
				a = (a + numb * Math.pow(10, -minusPos));
			} else {
				b = (b + numb * Math.pow(10, -minusPos));
			}
			this.minusPos++;
		}
	}

	public void chgSign(int entryPos) {
		if (entryPos == 1) {
			a = -a;
		} else {
			b = -b;
		}
	}

	public void del1(int entryPos, boolean pointSet) {
		if (!pointSet) {
			if (entryPos == 1) {
				a = a / 10;
				a = Math.floor(a);
			} else {
				b = b / 10;
				b = Math.floor(b);
			}
		} if(pointSet){
			this.minusPos--;
			if (entryPos == 1) {
				a = Math.floor(a * Math.pow(10, minusPos - 1)) / Math.pow(10, minusPos - 1);
			} else {
				b = Math.floor(b * Math.pow(10, minusPos - 1)) / Math.pow(10, minusPos - 1);
			}
		}
	}
	

	public void delMe() {
		a = 0;
		b = 0;
		result = 0;
		cString = "";
		minusPos = 1;
	}
}
