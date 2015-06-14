package name.chenyuelin.ejb.demo.sample.client;

import javax.naming.Context;
import javax.naming.InitialContext;

import name.chenyuelin.ejb.demo.sample.DBServiceRemote;

public class DBServiceClient {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();

			String path = "java:EJBDemoEAR/EJBDemo/DBService!name.chenyuelin.ejb.demo.sample.DBServiceRemote";
			
			DBServiceRemote remote = (DBServiceRemote) context.lookup(path);
			int[] i=remote.persist("我是T1", "我是T2",(byte)12,"ejb测试9");
			System.out.println(i[0]+"\t"+i[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
