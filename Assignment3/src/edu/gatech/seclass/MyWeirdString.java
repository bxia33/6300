package edu.gatech.seclass;

import java.util.*;

public class MyWeirdString implements MyWeirdStringInterface{
	private String weirdStr;
	public MyWeirdString(){
		weirdStr = new String();
	}
	
	public MyWeirdString(String string){
		if (string != null){
			this.weirdStr = string;
		}
		else {
			weirdStr = new String();
		}
	}
	
	public void setWeirdString(String string){
		if (string != null){
			weirdStr = string;
		}
		else{
			weirdStr = new String();
		}
	}
	
	public String getWeirdString(){
		return weirdStr;

	}
	
	public String getEvenCharacters(){
		String evenStr = new String();
		for (int i=1; i < weirdStr.length(); i+=2){
			String c = Character.toString(weirdStr.charAt(i));
			evenStr = evenStr.concat(c);
		}
		return evenStr;
	}
	
	public String getOddCharacters(){
		String oddStr = new String();
		for (int i=0; i < weirdStr.length(); i+=2){
			String c = Character.toString(weirdStr.charAt(i));
			oddStr = oddStr.concat(c);
		}
		return oddStr;
	}
	
	public int countDigits(){
		ArrayList<String> alpha = new ArrayList<String>(Arrays.asList("0","1","2","3","4", "5","6","7", "8","9"));
		int l = weirdStr.length();
		int sum = 0;
		for (int i =0; i <l; i++ ){
			String candidate = Character.toString(weirdStr.charAt(i));
			if (alpha.indexOf(candidate)!=-1){
				sum+=1;
			}
		}
		return sum;
	}
	
	public void convertDigitsToRomanNumeralsInSubstring(int startPosition, int endPosition)
			throws MyIndexOutOfBoundsException, IllegalArgumentException{
		int l = weirdStr.length();
		if (startPosition>l || endPosition>l || startPosition<1 || endPosition<1){
			throw new MyIndexOutOfBoundsException();
		}
		if (startPosition > endPosition){
			throw new IllegalArgumentException();
		}
		String prefix = weirdStr.substring(0,(startPosition-1));
		String surfix = weirdStr.substring(endPosition, l);
		String mid = weirdStr.substring(startPosition-1, endPosition);
		String roman[]={"I","II","III","IV","V","VI","VII","VIII","IX"};
		ArrayList<String> alpha = new ArrayList<String>(Arrays.asList("1","2","3","4", "5","6","7", "8","9"));
		String newMid = new String();
		for (int i = 0; i< mid.length(); i++){
			String candidate = Character.toString(mid.charAt(i));
			if (alpha.indexOf(candidate)!= -1){
				int can = alpha.indexOf(candidate);
//				System.out.println(can);
				candidate = roman[can];
//				System.out.println(candidate);
				newMid = newMid.concat(candidate);
			}
			else {newMid = newMid.concat(candidate);
			}
//			System.out.println(newMid);
		}
//		System.out.println(prefix + "1   "+ newMid +"2   " + surfix + "3   ");
		this.weirdStr = prefix + newMid + surfix;
	}


}
