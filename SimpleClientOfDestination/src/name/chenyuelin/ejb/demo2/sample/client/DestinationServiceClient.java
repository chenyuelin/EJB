package name.chenyuelin.ejb.demo2.sample.client;

import java.util.Objects;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.bind.DatatypeConverter;

import name.chenyuelin.ejb.demo2.sample.DestinationServiceRemote;

public class DestinationServiceClient {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();

			String path = "ejb:EJBDemoEAR2/EJBDemo2/DestinationService!name.chenyuelin.ejb.demo2.sample.DestinationServiceRemote";
			
			DestinationServiceRemote remote = (DestinationServiceRemote) context.lookup(path);
			System.out.println(Objects.toString(remote.updateAgent((byte)13,"jndi≤‚ ‘22")) );
		} catch (NamingException e) {
			e.printStackTrace();
		}
//		System.out.println(DatatypeConverter.printBase64Binary("123456".getBytes()));
	}

}
