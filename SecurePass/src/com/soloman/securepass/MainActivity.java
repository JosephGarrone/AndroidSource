package com.soloman.securepass;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.ads.AdRequest;
import com.google.ads.AdView;

public class MainActivity extends Activity {
	
	//Password security
	public Integer ambiguity = 0; //Possible characters
	public Integer charcount = 0; //Number of characters
	public BigInteger possiblecombinations = new BigInteger("0"); //Number of characters ^ possible characters
	public String password;
	public BigDecimal mstocrack = new BigDecimal("0");
	public BigDecimal cracksperms = new BigDecimal("32000000000"); //Quadcore 2.0GHz cpu
	
	//Regex
	final Pattern lalphabet = Pattern.compile("[a-z]"); //Lowercase pattern
	final Pattern ualphabet = Pattern.compile("[A-Z]"); //Uppercase pattern
	final Pattern numbers = Pattern.compile("[0-9]"); //Numbers
	final Pattern bsymbols = Pattern.compile("[-!$%^&*\\(\\)_+|~#=`{}\\[\\]:\";'<>@?,.\\\\/]"); //Basic symbols
	final Pattern latalphabet = Pattern.compile("[À-ÿ]"); //Latin alphabet
	final Pattern extrasymbols = Pattern.compile("[§¡-£¥©®°±™€¿]"); //Extra symbols
	Matcher matcher; //Global matcher
	
	//Background transition
	ColorDrawable original = new ColorDrawable(Color.rgb(229, 229, 229));
	ColorDrawable after = new ColorDrawable(Color.rgb(255, 0, 0));
	final Integer transduration = 500;
	
	//Controls
	EditText passwordfield;
	TextView ambiguityview;
	TextView characterview;
	TextView combinationsview;
	TextView crackview;
	LinearLayout farback;
	AdView adview;
	MenuItem shownumbers;
	
	//Settings and Misc
	boolean displayNumbers = false;
	String mainbody = "";
	Integer Rc = 255;
	Integer Gc = 0;
	Integer Bc = 0;
	
	//Time intervals
	final String milleniums = "31536000000";
	final String centurys = "3153600000";
	final String decades = "315360000";
	final String years = "31536000";
	final String days = "86400";
	final String hours = "3600";
	final String minutes = "60";
	final String seconds = "1";
		
	//Magnitudes
	final String million = "000 000";
	final String billion = "000 000 000";
	final String trillion = "000 000 000 000";
	final String quadrillion = "000 000 000 000 000";
	final String quintillion = "000 000 000 000 000 000";
	final String sextillion = "000 000 000 000 000 000 000";
	final String septillion = "000 000 000 000 000 000 000 000";
	final String octillion = "000 000 000 000 000 000 000 000 000";
	final String nonillion = "000 000 000 000 000 000 000 000 000 000";
	final String decillion = "000 000 000 000 000 000 000 000 000 000 000";
	final String undecillion = "000 000 000 000 000 000 000 000 000 000 000 000";
	final String duodecillion = "000 000 000 000 000 000 000 000 000 000 000 000 000";
	final String tredecillion = "000 000 000 000 000 000 000 000 000 000 000 000 000 000";
	final String quattuordecillion = "000 000 000 000 000 000 000 000 000 000 000 000 000 000 000";
	final String quindecillion = "000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000";
	final String sexdecillion = "000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000";
	final String septendecillion = "000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000";
	final String octodecillion = "000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000";
	final String novemdecillion = "000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000";
	final String vigintillion = "000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000";
	final String unvigintillion = "000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000";
	final String duovigintillion = "000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000";
	final String trevigintillion = "000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000";
	final String quattuorvigintillion = "000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000";
	final String quinvigintillion = "000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000";
	final String sexvigintillion = "000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000";
	final String septenvigintillion = "000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000";
	final String octovigintillion = "000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000";
	final String novemvigintillion = "000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000";
	final String trigintillion = "000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000";
	final String untrigintillion = "000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000";
	final String duotrigintillion = "000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000 000";
		
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		//Set controls
		passwordfield = (EditText) findViewById(R.id.passwordfield);
		ambiguityview = (TextView) findViewById(R.id.ambiguityview);
		characterview = (TextView) findViewById(R.id.characterview);
		combinationsview = (TextView) findViewById(R.id.combinationsview);
		crackview = (TextView)	findViewById(R.id.crackview);
		farback = (LinearLayout) findViewById(R.id.farback);
		adview = (AdView) findViewById(R.id.adview);
		
		//Get Adverts
		AdRequest re = new AdRequest();
		//re.setTesting(true);
		re.addKeyword("technology");
		re.addKeyword("security");
		re.addKeyword("games");
		adview.loadAd(re);
		
		//Set the voids
		passwordfield.addTextChangedListener(new TextWatcher() {

	        @Override
	        public void afterTextChanged(Editable arg0) {
	            // TODO Auto-generated method stub

	        }

	        @Override
	        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
	            // TODO Auto-generated method stub

	        }

	        @Override
	        public void onTextChanged(CharSequence s, int start, int before, int count) {
	        	password = passwordfield.getText().toString();
	        	
	        	Integer _ambiguity = 0;
	        	
	        	//Check for lowercase alphabet
	        	matcher = lalphabet.matcher(password);
	        	if (matcher.find()) {
	        		_ambiguity += 26;
	        	}
	        	
	        	//Check for uppercase alphabet
	        	matcher = ualphabet.matcher(password);
	        	if (matcher.find()) {
	        		_ambiguity += 26;
	        	}
	        	
	        	//Check for numbers
	        	matcher = numbers.matcher(password);
	        	if (matcher.find()) {
	        		_ambiguity += 10;
	        	}
	        	
	        	//Check for basic symbols
	        	matcher = bsymbols.matcher(password);
	        	if (matcher.find()) {
	        		_ambiguity += 32;
	        	}
	        	
	        	//Check for latin alphabet
	        	matcher = latalphabet.matcher(password);
	        	if (matcher.find()) {
	        		_ambiguity += 64;
	        	}
	        	
	        	//Check for extra symbols
	        	matcher = extrasymbols.matcher(password);
	        	if (matcher.find()) {
	        		_ambiguity += 12;
	        	}
	        	
	        	//Redeclare
	        	ambiguity = _ambiguity;
	        	charcount = passwordfield.length();
	        	possiblecombinations = new BigInteger(ambiguity.toString()).pow(charcount);
	        	
	        	//Temp things
	        	String _combinations = possiblecombinations.toString();
	        	StringBuilder str = new StringBuilder(_combinations);
	        	
	        	//Add whitespace
	        	int idx = str.length() - 3;
	        	while (idx > 0)
	        	{
	        	    str.insert(idx, " ");
	        	    idx = idx - 3;
	        	}
	        	_combinations = str.toString();
	        	
	        	//Replace 000's with string
	        	if (!displayNumbers) {
	        		String t = possiblecombinations.toString();
	        		_combinations = NumbersToWords(t);
	        	}
	        	
	        	//Calculate time taken to crack password and change background color
	        	mstocrack = new BigDecimal((new BigDecimal(possiblecombinations.toString()).divide(cracksperms, 20, RoundingMode.HALF_UP)).stripTrailingZeros().toPlainString());
	        	String crackstring = mstocrack.toPlainString() + " seconds";
	        	if (mstocrack.compareTo(new BigDecimal(milleniums)) >= 0) {
	        		if (!displayNumbers) {
	        			crackstring = NumbersToWords((mstocrack.divide(new BigDecimal(milleniums), 0, RoundingMode.HALF_UP)).toPlainString()) + " millenia";
	        		} else {
	        			crackstring = (mstocrack.divide(new BigDecimal(milleniums), 0, RoundingMode.HALF_UP)).toPlainString() + " millenia";
	        		}
	        		Rc = 0;
	        		Gc = 255;
	        		Bc = 0;
	        	} else if (mstocrack.compareTo(new BigDecimal(centurys)) >= 0) {
	        		crackstring = (mstocrack.divide(new BigDecimal(centurys), 0, RoundingMode.HALF_UP)).toPlainString() + " centuries";
	        		Rc = 0;
	        		Gc = 192;
	        		Bc = 64;
	        	} else if (mstocrack.compareTo(new BigDecimal(decades)) >= 0) {
	        		crackstring = (mstocrack.divide(new BigDecimal(decades), 0, RoundingMode.HALF_UP)).toPlainString() + " decades";
	        		Rc = 0;
	        		Gc = 128;
	        		Bc = 128;
	        	} else if (mstocrack.compareTo(new BigDecimal(years)) >= 0) {
	        		crackstring = (mstocrack.divide(new BigDecimal(years), 0, RoundingMode.HALF_UP)).toPlainString() + " years";
	        		Rc = 0;
	        		Gc = 64;
	        		Bc = 192;
	        	} else if (mstocrack.compareTo(new BigDecimal(days)) >= 0) {
	        		crackstring = (mstocrack.divide(new BigDecimal(days), 0, RoundingMode.HALF_UP)).toPlainString() + " days";
	        		Rc = 0;
	        		Gc = 0;
	        		Bc = 255;
	        	} else if (mstocrack.compareTo(new BigDecimal(hours)) >= 0) {
	        		crackstring = (mstocrack.divide(new BigDecimal(hours), 0, RoundingMode.HALF_UP)).toPlainString() + " hours";
	        		Rc = 64;
	        		Gc = 0;
	        		Bc = 192;
	        	} else if (mstocrack.compareTo(new BigDecimal(minutes)) >= 0) {
	        		crackstring = (mstocrack.divide(new BigDecimal(minutes), 0, RoundingMode.HALF_UP)).toPlainString() + " minutes";
	        		Rc = 128;
	        		Gc = 0;
	        		Bc = 128;
	        	} else if (mstocrack.compareTo(new BigDecimal(seconds)) >= 0) {
	        		crackstring = (mstocrack.divide(new BigDecimal(seconds), 0, RoundingMode.HALF_UP)).toPlainString() + " seconds";
	        		Rc = 192;
	        		Gc = 0;
	        		Bc = 64;
	        	} else {
	        	 	crackstring = mstocrack.toPlainString() + " seconds";
	        		Rc = 255;
	        		Gc = 0;
	        		Bc = 0;
	        	}
	        	
	        	//Check for null value and apply RGB to After
	        	if (password.length() == 0) {
	        		_combinations = "0";
	        		crackstring = "0";
	        		after = new ColorDrawable(Color.rgb(229, 229, 229));
	        	} else {
	        		after = new ColorDrawable(Color.rgb(Rc, Gc, Bc));
	        	}
	        	
	        	//Background Change
	        	TransitionDrawable backgroundtransition = new TransitionDrawable(new ColorDrawable[] {original, after});
	        	farback.setBackgroundDrawable(backgroundtransition);
	        	backgroundtransition.startTransition(transduration);
	        	original = after;
	        	
	        	//UI Change
	        	ambiguityview.setText("Number of Possible Characters: " + ambiguity.toString());
	        	characterview.setText("Length of Password: " + charcount.toString());
	        	combinationsview.setText("Combinations: " + _combinations);
	        	crackview.setText("Time to crack: " + crackstring);
	        	
	        	//TEMP FOR TESTING TODO: DELETE THIS!
	        	//Toast.makeText(getApplicationContext(), NumbersToWords("1000000"), 1).show();
	        }
	    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		super.onCreateOptionsMenu(menu);
		
		shownumbers = (MenuItem) menu.findItem(R.id.shownumbers);
		if (displayNumbers) {
			shownumbers.setChecked(false);
		} else {
			shownumbers.setChecked(true);
		}
		
		
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch(item.getItemId())
		{
			case R.id.changedevice:
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setTitle("Select a device");
				builder.setItems(R.array.devices_array, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						switch(which)
						{
							case 0:
								cracksperms = new BigDecimal("32000000000"); //Default
								break;
							case 1:
								cracksperms = new BigDecimal("20800000000"); //Your Device
								break;
							case 2:
								cracksperms = new BigDecimal("17690000000000000"); //Titan
								break;
							case 3:
								cracksperms = new BigDecimal("124800000000"); //i7 3770k
								break;
							case 4:
								cracksperms = new BigDecimal("480000000"); //Pentium I 120mhz
								break;
						}
						String ts = passwordfield.getText().toString();
						passwordfield.setText("");
						passwordfield.setText(ts);
					}
					
				});
				
				builder.show();
				return true;
			case R.id.shownumbers:
				if (displayNumbers) {
					displayNumbers = false;
					shownumbers.setChecked(true);
				} else {
					displayNumbers = true;
					shownumbers.setChecked(false);
				}
				String ts = passwordfield.getText().toString();
				passwordfield.setText("");
				passwordfield.setText(ts);
				return true;
			default:
				//Toast.makeText(this, String.valueOf(item.getItemId()) + String.valueOf(R.id.shownumbers) + String.valueOf(R.id.changedevice), 1).show();
				return super.onOptionsItemSelected(item);
		}
	}

	final String NumbersToWords(String input) {
		String t = input;
		String prefix = "Hi";
		String output = "";
		
		//Check if number is < 1 000 000 so no words used
		if (t.length() <= 6) {
			prefix = t;
			
        	StringBuilder tstr = new StringBuilder(t);
        	
        	//Add whitespace to whole number as < 1 000 000
        	int tidx = tstr.length() - 3;
        	while (tidx > 0)
        	{
        	    tstr.insert(tidx, " ");
        	    tidx = tidx - 3;
        	}
        	output = tstr.toString();
        	
		} else { //Otherwise if > 1 000 000 and the Mod of t.length() is > 3
    		if (t.length()%3 == 0) {
        		 prefix = possiblecombinations.toString().substring(0,3);
        		t = t.substring(3);
    		} else if (t.length()%3 == 2){
    			 prefix = possiblecombinations.toString().substring(0,2);
    			t = t.substring(2);
    		} else if (t.length()%3 == 1){
    			 prefix = possiblecombinations.toString().substring(0,1);
    			t = t.substring(1);
    		}
    		
    		//Required for adding whitespace to prefix (Non word part)
    		StringBuilder pstr = new StringBuilder(prefix);
        	
        	//Add whitespace to prefix
        	int pidx = pstr.length() - 3;
        	while (pidx > 0)
        	{
        	    pstr.insert(pidx, " ");
        	    pidx = pidx - 3;
        	}
        	
        	//Convert body numbers to string;
        	StringBuilder mainbuilder = new StringBuilder(output);
        	
        	while (t.length() >= 6) {
        	if (t.length() >= 99) {
        		mainbuilder.insert(0," duotrigintillion");
        		t = t.substring(0, t.length() - 99);
        	}

        	if (t.length() >= 96) {
        		mainbuilder.insert(0," untrigintillion");
        		t = t.substring(0, t.length() - 96);
        	}

        	if (t.length() >= 93) {
        		mainbuilder.insert(0," trigintillion");
        		t = t.substring(0, t.length() - 93);
        	}

        	if (t.length() >= 90) {
        		mainbuilder.insert(0," novemvigintillion");
        		t = t.substring(0, t.length() - 90);
        	}

        	if (t.length() >= 87) {
        		mainbuilder.insert(0," octovigintillion");
        		t = t.substring(0, t.length() - 87);
        	}

        	if (t.length() >= 84) {
        		mainbuilder.insert(0," septenvigintillion");
        		t = t.substring(0, t.length() - 84);
        	}

        	if (t.length() >= 81) {
        		mainbuilder.insert(0," sexvigintillion");
        		t = t.substring(0, t.length() - 81);
        	}

        	if (t.length() >= 78) {
        		mainbuilder.insert(0," quinvigintillion");
        		t = t.substring(0, t.length() - 78);
        	}

        	if (t.length() >= 75) {
        		mainbuilder.insert(0," quattuorvigintillion");
        		t = t.substring(0, t.length() - 75);
        	}

        	if (t.length() >= 72) {
        		mainbuilder.insert(0," trevigintillion");
        		t = t.substring(0, t.length() - 72);
        	}

        	if (t.length() >= 69) {
        		mainbuilder.insert(0," duovigintillion");
        		t = t.substring(0, t.length() - 69);
        	}

        	if (t.length() >= 66) {
        		mainbuilder.insert(0," unvigintillion");
        		t = t.substring(0, t.length() - 66);
        	}

        	if (t.length() >= 63) {
        		mainbuilder.insert(0," vigintillion");
        		t = t.substring(0, t.length() - 63);
        	}

        	if (t.length() >= 60) {
        		mainbuilder.insert(0," novemdecillion");
        		t = t.substring(0, t.length() - 60);
        	}

        	if (t.length() >= 57) {
        		mainbuilder.insert(0," octodecillion");
        		t = t.substring(0, t.length() - 57);
        	}

        	if (t.length() >= 54) {
        		mainbuilder.insert(0," septendecillion");
        		t = t.substring(0, t.length() - 54);
        	}

        	if (t.length() >= 51) {
        		mainbuilder.insert(0," sexdecillion");
        		t = t.substring(0, t.length() - 51);
        	}

        	if (t.length() >= 48) {
        		mainbuilder.insert(0," quindecillion");
        		t = t.substring(0, t.length() - 48);
        	}

        	if (t.length() >= 45) {
        		mainbuilder.insert(0," quattuordecillion");
        		t = t.substring(0, t.length() - 45);
        	}

        	if (t.length() >= 42) {
        		mainbuilder.insert(0," tredecillion");
        		t = t.substring(0, t.length() - 42);
        	}

        	if (t.length() >= 39) {
        		mainbuilder.insert(0," duodecillion");
        		t = t.substring(0, t.length() - 39);
        	}

        	if (t.length() >= 36) {
        		mainbuilder.insert(0," undecillion");
        		t = t.substring(0, t.length() - 36);
        	}

        	if (t.length() >= 33) {
        		mainbuilder.insert(0," decillion");
        		t = t.substring(0, t.length() - 33);
        	}

        	if (t.length() >= 30) {
        		mainbuilder.insert(0," nonillion");
        		t = t.substring(0, t.length() - 30);
        	}

        	if (t.length() >= 27) {
        		mainbuilder.insert(0," octillion");
        		t = t.substring(0, t.length() - 27);
        	}

        	if (t.length() >= 24) {
        		mainbuilder.insert(0," septillion");
        		t = t.substring(0, t.length() - 24);
        	}

        	if (t.length() >= 21) {
        		mainbuilder.insert(0," sextillion");
        		t = t.substring(0, t.length() - 21);
        	}

        	if (t.length() >= 18) {
        		mainbuilder.insert(0," quintillion");
        		t = t.substring(0, t.length() - 18);
        	}

        	if (t.length() >= 15) {
        		mainbuilder.insert(0," quadrillion");
        		t = t.substring(0, t.length() - 15);
        	}

        	if (t.length() >= 12) {
        		mainbuilder.insert(0," trillion");
        		t = t.substring(0, t.length() - 12);
        	}

        	if (t.length() >= 9) {
        		mainbuilder.insert(0," billion");
        		t = t.substring(0, t.length() - 9);
        	}

        	if (t.length() >= 6) {
        		mainbuilder.insert(0," million");
        		t = t.substring(0, t.length() - 6);
        	}
        	}
    		output = prefix + mainbuilder.toString();
		}	
		
		//Return output
    	return output;
	}

}
