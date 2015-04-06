package name.chenyuelin.ejb.demo.sample.client;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import name.chenyuelin.ejb.demo.sample.SayHelloRemote;

public class SayHelloClient {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();

			String path = "java:global/EJBDemoEAR/EJBDemo/SayHello!name.chenyuelin.ejb.demo.sample.SayHelloRemote";
			path="ejb:EJBDemoEAR/EJBDemo/SayHello!name.chenyuelin.ejb.demo.sample.SayHelloRemote";
			
			final String appName = "EJBDemoEAR";
	        // This is the module name of the deployed EJBs on the server. This is typically the jar name of the
	        // EJB deployment, without the .jar suffix, but can be overridden via the ejb-jar.xml
	        // In this example, we have deployed the EJBs in a jboss-as-ejb-remote-app.jar, so the module name is
	        // jboss-as-ejb-remote-app
	        final String moduleName = "EJBDemo";
	        // AS7 allows each deployment to have an (optional) distinct name. We haven't specified a distinct name for
	        // our EJB deployment, so this is an empty string
	        final String distinctName = "";
	        // The EJB name which by default is the simple class name of the bean implementation class
	        final String beanName = "SayHello";
	        // the remote view fully qualified class name
	        final String viewClassName = SayHelloRemote.class.getName();
	        // let's do the lookup
	        context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
			
			Object remote = context.lookup(path);
			SayHelloRemote sayHelloRemote=(SayHelloRemote)remote;
			System.out.println(sayHelloRemote.say());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
