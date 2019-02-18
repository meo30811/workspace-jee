package remy;

import java.util.Scanner;

public class Stromrechnung {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
double Maschineleistung;
int Startzeit;
int  Stoppzeit ;
double Strompreis;
double Nachttarif;
double Mengenrabatt;
double rabatt ;

int minute;
int stunden;

Scanner kemeni = new Scanner (System.in);
System.out.println("geben Sie Maschineleistung ein");
Maschineleistung = kemeni.nextDouble();
System.out.println("geben Sie Startzeit ein");
Startzeit = kemeni.nextInt();
System.out.println("geben Sie Stoppzeit");
Stoppzeit = kemeni.nextInt();
System.out.println("geben Sie Strompreis");
Strompreis = kemeni.nextDouble();
System.out.println("geben Sie Nachttarif ein");
Nachttarif = kemeni.nextDouble();
System.out.println("geben Sie Mengenrabatt");
Mengenrabatt = kemeni.nextDouble();
System.out.println("geben Sie rabatt");
rabatt = kemeni.nextDouble();
		

if(Maschineleistung < 0){
	System.out.println("Maschineleistung kann nicht negativ sein"); 
}

if(Startzeit < 0){
	System.out.println("Startzeit kann nicht negativ sein"); 
	
}
else if (Startzeit >= 0 && Startzeit <= 23){
	stunden = Startzeit/60;
	minute = Startzeit% 60;
	System.out.println(stunden +":"+ minute); 
	
	
	}

if(Stoppzeit < 0){
System.out.println("Stoppzeit kann nicht negativ sein");	
	
}
else if(Stoppzeit >=0 && Stoppzeit <23){
	stunden = Startzeit/60;
	minute = Startzeit% 60;
	System.out.println(stunden +":"+ minute); 
	}


if(Strompreis < 0){
	System.out.println("Strompreis kann nicht negativ sein");

}

}

	Tagesstromabnahme
	
}
