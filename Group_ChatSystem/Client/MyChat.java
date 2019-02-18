import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class MyChat implements Runnable {
	 public JTextField tx;
	    public JTextArea ta;
	    public String login="Imed";
	    BufferedWriter writer;
	    BufferedReader reader;

	    public MyChat(String l){
	        login=l;

	        JFrame f=new JFrame(login);
	        f.setSize(400,400);

	        JPanel p1=new JPanel();
	        p1.setLayout(new BorderLayout());

	        JPanel p2=new JPanel();
	        p2.setLayout(new BorderLayout());

	        tx=new JTextField();
	        p1.add(tx, BorderLayout.CENTER);

	        JButton b1=new JButton("Send");
	        p1.add(b1, BorderLayout.EAST);

	        ta=new JTextArea("welcome "+login+"! type text here to start chatting.\n=====================================\n");
	        p2.add(ta, BorderLayout.CENTER);
	        p2.add(p1, BorderLayout.SOUTH);

	        f.setContentPane(p2);
	        try{
             Socket socketClient= new Socket("localhost",5555);
             writer= new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
             reader =new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
    }catch(Exception e){e.printStackTrace();}

    b1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ev){
            String s=login+" : "+tx.getText();
            tx.setText("");
            try{
                writer.write(s);
                writer.write("\r\n");
                writer.flush();
                }catch(Exception e){e.printStackTrace();}
        }
      }
    );
	        f.setVisible(true);
	    }

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
                String serverMsg="";
                while((serverMsg = reader.readLine()) != null){
                    System.out.println("from server: " + serverMsg);
                    ta.append(serverMsg+"\n");
                }
        }catch(Exception e){e.printStackTrace();}
		}
}
