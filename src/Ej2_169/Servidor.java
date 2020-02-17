package Ej2_169;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Servidor {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
	
		DatagramSocket socket=new DatagramSocket(12345);
		byte[] recibidos=new byte[1024];
		
		System.out.println("Esperando datagrama...");
		DatagramPacket recibo=new DatagramPacket(recibidos,recibidos.length);

		socket.receive(recibo);


		ByteArrayInputStream bais=new ByteArrayInputStream(recibidos);
		ObjectInputStream in=new ObjectInputStream(bais);

		Persona persona=(Persona) in.readObject();
		System.out.println(persona.getNombre());
		System.out.println(persona.getEdad());
		

		int puertoEnvio=recibo.getPort();
		in.close();
		
		
		persona.setEdad(24);
		persona.setNombre("Juan");
		
		ByteArrayOutputStream bs=new ByteArrayOutputStream();
		ObjectOutputStream out=new ObjectOutputStream(bs);

		out.writeObject(persona);
		out.close();
		
		byte[] mensaje=bs.toByteArray();
		
		InetAddress destino=InetAddress.getLocalHost();
		int port=12346;
		

		DatagramPacket envio=new DatagramPacket(mensaje, mensaje.length,destino,puertoEnvio);
		

		socket.send(envio);
		socket.close();
	}

}
