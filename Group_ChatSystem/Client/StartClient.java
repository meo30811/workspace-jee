import java.util.Scanner;

public class StartClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan= new Scanner(System.in);

		System.out.println("please give your username to start chatting: ");
		String username = scan.nextLine();
		 try{
	            MyChat c=new MyChat(username);
	            new Thread(c).start();

	     }catch(Exception e){e.printStackTrace();}
		}
}
