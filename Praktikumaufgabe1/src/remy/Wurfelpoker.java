package remy;

import java.util.Scanner;

public class Wurfelpoker {

	public static void main(String[] args) {
		
int roll1;
int roll2;
int roll3;
int Ergebnis =0;


Scanner kemeni = new Scanner(System.in);
System.out.println("geben Sie die roll1 ein");
roll1 = kemeni.nextInt();
System.out.println("geben Sie die roll2 ein");

roll2 = kemeni.nextInt();

System.out.println("geben Sie roll3 ein");

roll3 = kemeni.nextInt();

if(roll1 == roll2 && roll1 == roll3 && roll2 ==roll3){
Ergebnis = 2;
System.out.println(roll1 +","+roll2+","+ roll3+ "=>"+ Ergebnis+"für Drilling");
	
}
if(roll1 % 2 == 0 && roll2 % 2 ==0 && roll3 % 2 ==0 ){
	
	Ergebnis = 1;
	System.out.println(roll1 +","+roll2+","+ roll3+ "=>"+ Ergebnis+"für Zweierpotenzen");
			
	
}

if ( roll1 == roll2 || roll1 == roll3 && roll2 == roll3 || roll1 == roll3 ){
	
	Ergebnis = 3;
	System.out.println(roll1 +","+roll2+","+ roll3+ "=>"+ Ergebnis+"für Zwilling");
		
}

if (roll1 % 2 ==1 && roll2 % 2 == 1 && roll3 % 2 ==1){
	Ergebnis = 4;
	System.out.println(roll1 +","+roll2+","+ roll3+ "=>"+ Ergebnis+" nichts von alledem");
		
	
}
	







		// TODO Auto-generated method stub

	}

}
