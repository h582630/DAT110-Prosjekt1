package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;

import no.hvl.dat110.TODO;

public class RPCUtils {

	// Utility methods for marshalling and marshalling of parameters and return values
	// in RPC request and RPC responses
	// data bytearrays and return byte arrays is according to the 
	// RPC message syntax [rpcid,parameter/return value]
	
	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded = new byte[str.length() + 1];
		
		encoded[0] = rpcid; 

		for(int i = 0; i < str.length(); i++) {
			encoded[i+1] = str.getBytes()[i]; 
		}
		

		return encoded;
	}

	public static String unmarshallString(byte[] data) {
 
		String unmarshall = null; 
		byte [] decoded = new byte[data.length-1]; 
		
		for(int i = 0; i < decoded.length; i++) {
			decoded[i] = data[i+1]; 
		}
		
		unmarshall = new String(decoded); 
		
		return unmarshall; 
		
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded = new byte[1];
		
		encoded[0] = rpcid; 
		

		// TODO: marshall RPC identifier in case of void type

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// unuseful
	
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] encoded = new byte[5];
		
		 encoded[0] = rpcid; 
		
		
		byte[] intToBytes = ByteBuffer.allocate(4).putInt(x).array();
		
		
		for(int i = 0; i < intToBytes.length; i++) {
			encoded[i + 1] = intToBytes[i]; 
		}
		
		return encoded; 

		// TODO: marshall RPC identifier and string into byte array
		
		
	}

	public static int unmarshallInteger(byte[] data) {
		
		byte [] bytesToInt = new byte[data.length - 1]; 
		
		for(int i = 0; i < bytesToInt.length; i++) {
			bytesToInt[i] = data[i+1]; 
		}
	
	
		int decoded = ByteBuffer.wrap(bytesToInt).getInt();
		return decoded;

	}
}
