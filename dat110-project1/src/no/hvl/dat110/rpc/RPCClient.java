package no.hvl.dat110.rpc;

import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.*;

public class RPCClient {

	private MessagingClient msgclient;
	private Connection connection;

	public RPCClient(String server, int port) {

		msgclient = new MessagingClient(server, port);
	}

	public void register(RPCStub remote) {
		remote.register(this);
	}

	public void connect() {
		connection = msgclient.connect();

	}

	public void disconnect() {
		if (connection != null) {
			connection.close();
		}
	}

	public byte[] call(byte[] rpcrequest) {

		
		if(connection == null) {
			connect(); 
		}
		
		
		
		connection.send(new Message(rpcrequest));
		return connection.receive().getData();

		/*
		 * TODO:
		 * 
		 * Make a remote call on the RPC server by sending the RPC request message and
		 * receive an RPC reply message
		 * 
		 * rpcrequest is the marshalled rpcrequest from the client-stub rpctreply is the
		 * rpcreply to be unmarshalled by the client-stub
		 * 
		 */

	}

}
