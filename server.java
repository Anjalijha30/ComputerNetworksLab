package Project1;
import javax.swing.*;
import java.net.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class server {

	public static void main(String[] args)throws Exception{
		ServerSocket server=null;
		Socket socket;
		server=new ServerSocket(4025);
		System.out.println("Server Waiting for image");
		socket=server.accept();
		InputStream in=socket.getInputStream();
		DataInputStream dis=new DataInputStream(in);
		int len=dis.readInt();
		byte[] data=new byte[len];
		dis.readFully(data);
		dis.close();
		in.close();
		server.close();
		InputStream ian=new ByteArrayInputStream(data);
		BufferedImage bImage=ImageIO.read(ian);
		JFrame f=new JFrame("Server");
		ImageIcon icon=new ImageIcon(bImage);
		JLabel l=new JLabel();
		l.setIcon(icon);
		f.add(l);
		f.pack();
		f.setVisible(true);
	}

}
