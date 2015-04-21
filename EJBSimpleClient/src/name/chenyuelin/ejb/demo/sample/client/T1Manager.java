package name.chenyuelin.ejb.demo.sample.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import name.chenyuelin.ejb.demo.sample.BoxRemote;
import name.chenyuelin.ejb.demo.sample.T1ServiceRemote;

public class T1Manager {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();

			String path = "java:EJBDemoEAR/EJBDemo/T1Service!name.chenyuelin.ejb.demo.sample.T1ServiceRemote";
			
			T1ServiceRemote remote = (T1ServiceRemote) context.lookup(path);
			System.out.println(remote.getT1(1));
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

}
