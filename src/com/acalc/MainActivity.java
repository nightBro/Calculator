package com.acalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	TextView showTextEntry;
	TextView showTextResult;
	Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
	Button bDevide, bEquals, bMinus, bMult, bPlus, bHigh2, bHigh, bSqrt, bPi; 
	Button bPoint, bDelEntry, bDel1, bPandM;
	ScrollView sView;

	int aLength = 40;
	public entry[] cArray = new entry[aLength];
	TextView[] myText = new TextView[aLength];

	int cArrayI = 0;
	int entryPos = 1;

	int scrolTo = 0;
	boolean bPointpres = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		LinearLayout lin = (LinearLayout) findViewById(R.id.LinearLayoutScroll);
		for (int i = 0; i < aLength - 1; i++) {
			myText[i] = new TextView(this);
			myText[i].setText("");
			myText[i].setTextSize(20);
			lin.addView(myText[i]);
		}
		for(int i = 0; i < cArray.length - 1; i++){
			cArray[i] = new entry();
		}

		// Fiend Elements
		b0 = (Button) findViewById(R.id.b0);
		b1 = (Button) findViewById(R.id.b1);
		b2 = (Button) findViewById(R.id.b2);
		b3 = (Button) findViewById(R.id.b3);
		b4 = (Button) findViewById(R.id.b4);
		b5 = (Button) findViewById(R.id.b5);
		b6 = (Button) findViewById(R.id.b6);
		b7 = (Button) findViewById(R.id.b7);
		b8 = (Button) findViewById(R.id.b8);
		b9 = (Button) findViewById(R.id.b9);

		bPlus = (Button) findViewById(R.id.bPlus);
		bMinus = (Button) findViewById(R.id.bMinus);
		bMult = (Button) findViewById(R.id.bMult);
		bDevide = (Button) findViewById(R.id.bDevide);
		bHigh2 = (Button) findViewById(R.id.bHigh2);
		bHigh = (Button) findViewById(R.id.bHigh);
		bPi = (Button) findViewById(R.id.bPi);
		bSqrt = (Button) findViewById(R.id.bSqrt);
		bPandM = (Button) findViewById(R.id.bPaM);
		bEquals = (Button) findViewById(R.id.bEq);
		bPoint = (Button) findViewById(R.id.bPoint);
		bDelEntry = (Button) findViewById(R.id.bDelEntry);
		bDel1 = (Button) findViewById(R.id.bDel1);
		sView = (ScrollView) findViewById(R.id.scrollView1);

		b0.setOnClickListener(this);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		b5.setOnClickListener(this);
		b6.setOnClickListener(this);
		b7.setOnClickListener(this);
		b8.setOnClickListener(this);
		b9.setOnClickListener(this);
		bDevide.setOnClickListener(this);
		bPlus.setOnClickListener(this);
		bMinus.setOnClickListener(this);
		bMult.setOnClickListener(this);
		bHigh.setOnClickListener(this);
		bHigh2.setOnClickListener(this);
		bSqrt.setOnClickListener(this);
		bPi.setOnClickListener(this);
		bEquals.setOnClickListener(this);
		bPandM.setOnClickListener(this);
		bPoint.setOnClickListener(this);
		bDelEntry.setOnClickListener(this);
		bDel1.setOnClickListener(this);
	}

	public void showResult() {
		try{
			cArray[cArrayI].calculate();
			showEntries();

			cArrayI += 1;
			entryPos = 1;
			entryPos = 1;
			bPointpres = false;

			if (cArrayI > 1) {
				scrolTo += 100;
				sView.smoothScrollTo(0, scrolTo);
			}
		}catch(java.lang.IndexOutOfBoundsException e){
			
		}
	}

	public void showEntries() {
		for (int i = 0; i < cArray.length - 1; i++) {
			myText[i].setText(cArray[i].toString());
		}
	}

	public void grapPos() {
		if (cArrayI >= 1) {
			if (cArray[cArrayI].a == 0) {
				cArray[cArrayI].a = cArray[cArrayI - 1].result;
			}
		}
		bPointpres = false;
	}

	public void addNum(int a) {
		cArray[cArrayI].addNumber(a, entryPos, bPointpres);
		showEntries();
	}

	public void addCalcString(String cString) {
		if(cArray[cArrayI].b != 0){
			showResult();
		}
		if(!cString.equals("s")){
			if (cArray[cArrayI].b == 0) {
				entryPos = 2;
			}
		}
		grapPos();
		cArray[cArrayI].cString = cString;
		cArray[cArrayI].minusPos = 1;
		showEntries();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
		case R.id.b0:
			addNum(0);
			break;
		case R.id.b1:
			addNum(1);
			break;
		case R.id.b2:
			addNum(2);
			break;
		case R.id.b3:
			addNum(3);
			break;
		case R.id.b4:
			addNum(4);
			break;
		case R.id.b5:
			addNum(5);
			break;
		case R.id.b6:
			addNum(6);
			break;
		case R.id.b7:
			addNum(7);
			break;
		case R.id.b8:
			addNum(8);
			break;
		case R.id.b9:
			addNum(9);
			break;
		case R.id.bPlus:
			addCalcString("+");
			break;
		case R.id.bMinus:
			addCalcString("-");
			break;
		case R.id.bMult:
			addCalcString("*");
			break;
		case R.id.bDevide:
			addCalcString("/");
			break;
		case R.id.bHigh2:
			cArray[cArrayI].b = 2;
			addCalcString("^");
			break;
		case R.id.bHigh:
			addCalcString("^");
			break;
		case R.id.bPi:
			cArray[cArrayI].b = Math.PI;
			showEntries();
			break;
		case R.id.bSqrt:
			addCalcString("s");
			break;
			
		case R.id.bPaM:
			if (cArrayI >= 1) {
				if (cArray[cArrayI].a == 0) {
					cArray[cArrayI].a = cArray[cArrayI - 1].result;
				}
			}
			cArray[cArrayI].chgSign(entryPos);
			showEntries();
			break;
			
		case R.id.bEq:
			showResult();
			break;
			
		case R.id.bPoint:
			bPointpres = !bPointpres;
			break;
			
		case R.id.bDelEntry:
			for (int i = 0; i < cArray.length - 1; i++) {
				cArray[i].delMe();
			}
			cArrayI = 0;
			entryPos = 1;
			bPointpres = false;
			showEntries();
			scrolTo = 0;
			sView.smoothScrollTo(0, scrolTo);
			break;
			
		case R.id.bDel1:
			cArray[cArrayI].del1(entryPos, bPointpres);
			showEntries();
			break;
		
		case R.id.action_settings:
			Intent intent = new Intent(this, Preferences.class);
			startActivity(intent);
			break;
		}
	}

}
