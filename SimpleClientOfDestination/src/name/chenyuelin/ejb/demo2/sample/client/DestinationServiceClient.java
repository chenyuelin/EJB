package name.chenyuelin.ejb.demo2.sample.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import name.chenyuelin.ejb.demo2.sample.DestinationServiceRemote;

public class DestinationServiceClient {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();

			String path = "ejb:EJBDemoEAR2/EJBDemo2/DestinationService!name.chenyuelin.ejb.demo2.sample.DestinationServiceRemote";
			
			DestinationServiceRemote remote = (DestinationServiceRemote) context.lookup(path);
			System.out.println(remote.getAgent((byte)1));
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

}
