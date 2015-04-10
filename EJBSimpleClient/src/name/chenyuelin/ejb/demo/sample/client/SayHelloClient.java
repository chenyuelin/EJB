package name.chenyuelin.ejb.demo.sample.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import name.chenyuelin.ejb.demo.sample.SayHelloRemote;

public class SayHelloClient {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();

			String path = "java:global/EJBDemoEAR/EJBDemo/SayHello!name.chenyuelin.ejb.demo.sample.SayHelloRemote";
			path="ejb:EJBDemoEAR/EJBDemo//SayHello!name.chenyuelin.ejb.demo.sample.SayHelloRemote";
			
			Object remote = context.lookup(path);
			SayHelloRemote sayHelloRemote=(SayHelloRemote)remote;
			System.out.println(sayHelloRemote.say());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
