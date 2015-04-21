package name.chenyuelin.ejb.demo.sample.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import name.chenyuelin.ejb.demo.sample.BoxRemote;
import name.chenyuelin.ejb.demo.sample.SingletonBeanRemote;

public class SingletonBeanClient {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();

			String path = "ejb:EJBDemoEAR/EJBDemo/Box!name.chenyuelin.ejb.demo.sample.BoxRemote?stateful";
			path="java:EJBDemoEAR/EJBDemo/SingletonBean!name.chenyuelin.ejb.demo.sample.SingletonBeanRemote";
			
			SingletonBeanRemote remote = (SingletonBeanRemote) context.lookup(path);
			System.out.println(remote.getStatus());
			remote.setStatus(200);
			System.out.println(remote.getStatus());
			
			remote = (SingletonBeanRemote) context.lookup(path);
			System.out.println(remote.getStatus());
			remote.setStatus(400);
			System.out.println(remote.getStatus());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
