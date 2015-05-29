import java.util.Scanner;

public class DigitDisplay {
	public static void main (String args[]) {
		new DigitDisplay();
	}
	
	public DigitDisplay (){
		Scanner sc = new Scanner (System.in);
		System.out.println ("Enter a number:");
		String num = String.valueOf(sc.nextInt());
		System.out.println ("Enter size:");
		int size = sc.nextInt();
		
		while (num.length()>0) {
			display (num.charAt(0), size);
			num = num.substring(1);
		}
	}
	
	public void display (char number, int size) {
		if (number=='0') {
			// First Line
			System.out.print (String.format("%"+ (1) +"s", " "));
			for (int i=0; i<size; i++) {
				System.out.print ("-");
			}
			System.out.print (" \n");
			
			// First Half
			for (int i=0; i<size; i++) {
				System.out.print ("|");
				for (int j=0; j<size; j++) {
					System.out.print (" ");
				}
				System.out.print ("|\n");
			}
			
			// Middle Line
			System.out.println (String.format("%"+ (size+2) +"s", " "));
			
			// Second Half
			for (int i=0; i<size; i++) {
				System.out.print ("|");
				for (int j=0; j<size; j++) {
					System.out.print (" ");
				}
				System.out.print ("|\n");
			}
			
			// Last Line
			System.out.print (String.format("%"+ (1) +"s", " "));
			for (int i=0; i<size; i++) {
				System.out.print ("-");
			}
			System.out.print (" \n");
									
		} else if (number=='1') {
			// First Line
			System.out.print (String.format("%"+ (size+2) +"s", " ")+"\n");
				
			// First Half		
			for (int i=0; i<size; i++) {
				for (int j=0; j<=size; j++) {
					System.out.print (" ");
				}
				System.out.print ("|\n");
			}
			// Middle Line
			System.out.print (String.format("%"+ (size+2) +"s", " ")+"\n");
			
			// Second Half
			for (int i=0; i<size; i++) {
				for (int j=0; j<=size; j++) {
					System.out.print (" ");
				}
				System.out.print ("|\n");
			}
			// Last Line			
			System.out.print (String.format("%"+ (size+2) +"s", " ")+"\n");

		} else if (number=='2') {
			// First Line
			System.out.print (String.format("%"+ (1) +"s", " "));
			for (int i=0; i<size; i++) {
				System.out.print ("-");
			}
			System.out.print (" \n");
			
			// First Half
			for (int i=0; i<size; i++) {
				System.out.print (" ");
				for (int j=0; j<size; j++) {
					System.out.print (" ");
				}
				System.out.print ("|\n");
			}
			
			// Middle Line
			System.out.print (String.format("%"+ (1) +"s", " "));
			for (int i=0; i<size; i++) {
				System.out.print ("-");
			}
			System.out.print (" \n");
						
			// Second Half
			for (int i=0; i<size; i++) {
				System.out.print ("|");
				for (int j=0; j<size; j++) {
					System.out.print (" ");
				}
				System.out.print (" \n");
			}
			
			// Last Line
			System.out.print (String.format("%"+ (1) +"s", " "));
			for (int i=0; i<size; i++) {
				System.out.print ("-");
			}
			System.out.print (" \n");
			
			} else if (number=='3') {
			// First Line
			System.out.print (String.format("%"+ (1) +"s", " "));
			for (int i=0; i<size; i++) {
				System.out.print ("-");
			}
			System.out.print (" \n");
			
			// First Half
			for (int i=0; i<size; i++) {
				System.out.print (" ");
				for (int j=0; j<size; j++) {
					System.out.print (" ");
				}
				System.out.print ("|\n");
			}
			
			// Middle Line
			System.out.print (String.format("%"+ (1) +"s", " "));
			for (int i=0; i<size; i++) {
				System.out.print ("-");
			}
			System.out.print (" \n");
						
			// Second Half
			for (int i=0; i<size; i++) {
				System.out.print (" ");
				for (int j=0; j<size; j++) {
					System.out.print (" ");
				}
				System.out.print ("|\n");
			}
			
			// Last Line
			System.out.print (String.format("%"+ (1) +"s", " "));
			for (int i=0; i<size; i++) {
				System.out.print ("-");
			}
			System.out.print (" \n");		
		} else if (number=='4') {
			// First Line
			System.out.print (String.format("%"+ (size+2) +"s", " ") + "\n");
			
			// First Half
			for (int i=0; i<size; i++) {
				System.out.print ("|");
				for (int j=0; j<size; j++) {
					System.out.print (" ");
				}
				System.out.print ("|\n");
			}
			
			// Middle Line
			System.out.print (String.format("%"+ (1) +"s", " "));
			for (int i=0; i<size; i++) {
				System.out.print ("-");
			}
			System.out.print (" \n");	
						
			// Second Half
			for (int i=0; i<size; i++) {
				System.out.print (" ");
				for (int j=0; j<size; j++) {
					System.out.print (" ");
				}
				System.out.print ("|\n");
			}
			
			// Last Line
			System.out.print (String.format("%"+ (1) +"s", " "));
			for (int i=0; i<size; i++) {
				System.out.print ("-");
			}
			System.out.print (" \n");		
		} else if (number=='5') {
			// First Line
			System.out.print (String.format("%"+ (1) +"s", " "));
			for (int i=0; i<size; i++) {
				System.out.print ("-");
			}
			System.out.print (" \n");
			
			// First Half
			for (int i=0; i<size; i++) {
				System.out.print ("|");
				for (int j=0; j<size; j++) {
					System.out.print (" ");
				}
				System.out.print (" \n");
			}
			
			// Middle Line
			System.out.print (String.format("%"+ (1) +"s", " "));
			for (int i=0; i<size; i++) {
				System.out.print ("-");
			}
			System.out.print (" \n");	
						
			// Second Half
			for (int i=0; i<size; i++) {
				System.out.print (" ");
				for (int j=0; j<size; j++) {
					System.out.print (" ");
				}
				System.out.print ("|\n");
			}
			
			// Last Line
			System.out.print (String.format("%"+ (1) +"s", " "));
			for (int i=0; i<size; i++) {
				System.out.print ("-");
			}
			System.out.print (" \n");			
		} else if (number=='6') {
			// First Line
			System.out.print (String.format("%"+ (1) +"s", " "));
			for (int i=0; i<size; i++) {
				System.out.print ("-");
			}
			System.out.print (" \n");
			
			// First Half
			for (int i=0; i<size; i++) {
				System.out.print ("|");
				for (int j=0; j<size; j++) {
					System.out.print (" ");
				}
				System.out.print (" \n");
			}
			
			// Middle Line
			System.out.print (String.format("%"+ (1) +"s", " "));
			for (int i=0; i<size; i++) {
				System.out.print ("-");
			}
			System.out.print (" \n");	
						
			// Second Half
			for (int i=0; i<size; i++) {
				System.out.print ("|");
				for (int j=0; j<size; j++) {
					System.out.print (" ");
				}
				System.out.print ("|\n");
			}
			
			// Last Line
			System.out.print (String.format("%"+ (1) +"s", " "));
			for (int i=0; i<size; i++) {
				System.out.print ("-");
			}
			System.out.print (" \n");		
		} else if (number=='7') {
			// First Line
			System.out.print (String.format("%"+ (1) +"s", " "));
			for (int i=0; i<size; i++) {
				System.out.print ("-");
			}
			System.out.print (" \n");
			
			// First Half
			for (int i=0; i<size; i++) {
				System.out.print (" ");
				for (int j=0; j<size; j++) {
					System.out.print (" ");
				}
				System.out.print ("|\n");
			}
			
			// Middle Line
			System.out.println (String.format("%"+ (size+2) +"s", " "));
			
			// Second Half
			for (int i=0; i<size; i++) {
				System.out.print (" ");
				for (int j=0; j<size; j++) {
					System.out.print (" ");
				}
				System.out.print ("|\n");
			}
			
			// Last Line
			System.out.print (String.format("%"+ (size+2) +"s", " ") + "\n");		
		} else if (number=='8') {
			// First Line
			System.out.print (String.format("%"+ (1) +"s", " "));
			for (int i=0; i<size; i++) {
				System.out.print ("-");
			}
			System.out.print (" \n");
			
			// First Half
			for (int i=0; i<size; i++) {
				System.out.print ("|");
				for (int j=0; j<size; j++) {
					System.out.print (" ");
				}
				System.out.print ("|\n");
			}
			
			// Middle Line
			System.out.print (String.format("%"+ (1) +"s", " "));
			for (int i=0; i<size; i++) {
				System.out.print ("-");
			}
			System.out.print (" \n");	
						
			// Second Half
			for (int i=0; i<size; i++) {
				System.out.print ("|");
				for (int j=0; j<size; j++) {
					System.out.print (" ");
				}
				System.out.print ("|\n");
			}
			
			// Last Line
			System.out.print (String.format("%"+ (1) +"s", " "));
			for (int i=0; i<size; i++) {
				System.out.print ("-");
			}
			System.out.print (" \n");		
		} else if (number=='9') {
			// First Line
			System.out.print (String.format("%"+ (1) +"s", " "));
			for (int i=0; i<size; i++) {
				System.out.print ("-");
			}
			System.out.print (" \n");
			
			// First Half
			for (int i=0; i<size; i++) {
				System.out.print ("|");
				for (int j=0; j<size; j++) {
					System.out.print (" ");
				}
				System.out.print ("|\n");
			}
			
			// Middle Line
			System.out.print (String.format("%"+ (1) +"s", " "));
			for (int i=0; i<size; i++) {
				System.out.print ("-");
			}
			System.out.print (" \n");
							
			// Second Half
			for (int i=0; i<size; i++) {
				for (int j=0; j<=size; j++) {
					System.out.print (" ");
				}
				System.out.print ("|\n");
			}
			
			// Last Line
			System.out.print (String.format("%"+ (1) +"s", " "));
			for (int i=0; i<size; i++) {
				System.out.print ("-");
			}
			System.out.print (" \n");		
		} else {// not a number
			System.out.println ("Cannot display non-integers");
		}					
	}
}
