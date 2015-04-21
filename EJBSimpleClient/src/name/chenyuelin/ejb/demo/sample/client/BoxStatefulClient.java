package name.chenyuelin.ejb.demo.sample.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import name.chenyuelin.ejb.demo.sample.BoxRemote;

public class BoxStatefulClient {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();

			String path = "ejb:EJBDemoEAR/EJBDemo/Box!name.chenyuelin.ejb.demo.sample.BoxRemote?stateful";
			path="java:EJBDemoEAR/EJBDemo/Box!name.chenyuelin.ejb.demo.sample.BoxRemote";
			
			BoxRemote remote = (BoxRemote) context.lookup(path);
			System.out.println(remote.showStatus());
			remote.add(10);
			System.out.println(remote.showStatus());
			
			remote.remove();
			
			remote = (BoxRemote) context.lookup(path);
			remote.add(10);
			System.out.println(remote.showStatus());
			remote.remove();
			
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

}
