package name.cyl.ejbclient;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import name.cyl.ebj.Ejb2Remote;

public class RemoteEJBClient {

	public static void main(String[] args)throws Exception {
//		Hashtable<String,String> jndiProperties = new Hashtable<String,String>();
//        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        Context context = new InitialContext();
        final String appName = "EAP1";
        final String moduleName = "EJB1";
        final String distinctName = "";
        final String beanName = "Ejb2";
        final String viewClassName = "name.cyl.ebj.Ejb2Remote";
//        Ejb2Remote ejb2Remote= (Ejb2Remote) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
        Ejb2Remote ejb2Remote= (Ejb2Remote) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
        ejb2Remote.say();
        System.out.println(123);
	}

}
