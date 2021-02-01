package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class Message {

	private final int MESSAGE_SIZE = 128; 
	
	private byte[] payload;

	public Message(byte[] payload) {
		if(payload.length < MESSAGE_SIZE) {
		this.payload = payload;
		
		}
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload; 
	}

	public byte[] encapsulate() {
		
		byte[] encoded = null;
		
		// TODO
		// encapulate/encode the payload of this message in the
		// encoded byte array according to message format
		
		if (true)
		   throw new UnsupportedOperationException(TODO.method());

		return encoded;
		
	}

	public void decapsulate(byte[] received) {

		// TODO
		// decapsulate the data contained in the received byte array and store it 
		// in the payload of this message
		
		throw new UnsupportedOperationException(TODO.method());
		
	}
}
