package remy;
public class Peaks extends PeakCountBase {

	public static void main(String[] args) {
		setup(args);


	int peak = 0;
	int value = nextValue();
	int previousvalue;
	boolean smaller = false;


	while(value > -1) {	


		previousvalue = value;
		value = nextValue();

		if(previousvalue < value) {

			smaller = true;
		}

		else if(previousvalue > value && smaller == true) {
			
			peak++;
			smaller = false;
			
		}

		else if(nextValue() == -1) {
	
			value = -1;

		}
		
	}

	System.out.println(peak);

	
}
}