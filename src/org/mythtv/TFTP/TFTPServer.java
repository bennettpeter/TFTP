package org.mythtv.TFTP;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TFTPServer {

	public static void main(String argv[]) {
		try {
			// use port 6973
			DatagramSocket sock = new DatagramSocket(6973);
			System.out.println("Server Ready.  Port:  " + sock.getLocalPort());

			// Listen for requests
			while (true) {
				TFTPpacket in = TFTPpacket.receive(sock);
				// receive read request
				if (in instanceof TFTPread) {
					System.out.println("Read Request from " + in.getAddress());
					new TFTPserverRRQ((TFTPread) in);
				}
				// receive write request
				else if (in instanceof TFTPwrite) {
					System.out.println("Write Request from " + in.getAddress());
					new TFTPserverWRQ((TFTPwrite) in);
				}
			}
		} catch (SocketException e) {
			System.out.println("Server terminated(SocketException) " + e.getMessage());
		} catch (TftpException e) {
			System.out.println("Server terminated(TftpException)" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Server terminated(IOException)" + e.getMessage());
		}
	}
}