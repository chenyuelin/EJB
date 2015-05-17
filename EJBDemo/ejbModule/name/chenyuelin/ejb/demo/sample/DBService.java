package name.chenyuelin.ejb.demo.sample;

import java.rmi.RemoteException;
import java.util.Hashtable;

import javax.annotation.Resource;
import javax.ejb.AfterBegin;
import javax.ejb.AfterCompletion;
import javax.ejb.BeforeCompletion;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.naming.Context;

import name.chenyuelin.ejb.demo.sample.eao.T1EAO;
import name.chenyuelin.ejb.demo.sample.eao.T2EAO;
import name.chenyuelin.ejb.demo.sample.model.T1;
import name.chenyuelin.ejb.demo.sample.model2.T2;
import name.chenyuelin.ejb.demo2.sample.DestinationServiceRemote;

/**
 * Session Bean implementation class DBService
 */
@Stateless
@Remote(DBServiceRemote.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class DBService implements DBServiceRemote {
	@Resource
	private SessionContext sc;

	@EJB(lookup="ejb:EJBDemoEAR2/EJBDemo2/DestinationService!name.chenyuelin.ejb.demo2.sample.DestinationServiceRemote")
	private DestinationServiceRemote destinationServiceRemote;
	
	@EJB
	private T1EAO t1EAO;

	@EJB
	private T2EAO t2EAO;

	public int[] persist(String content, String name) throws Exception{
		try {
            final Hashtable props = new Hashtable();
            // setup the ejb: namespace URL factory
            props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            // create the InitialContext
            final Context context = new javax.naming.InitialContext(props);
 
            // Lookup the Greeter bean using the ejb: namespace syntax which is explained here https://docs.jboss.org/author/display/AS71/EJB+invocations+from+a+remote+client+using+JNDI
            final DestinationServiceRemote bean = (DestinationServiceRemote) context.lookup("ejb:EJBDemoEAR2/EJBDemo2/DestinationService!name.chenyuelin.ejb.demo2.sample.DestinationServiceRemote");
 
            // invoke on the bean
            System.out.println(bean.getAgent((byte)1));
 
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
		try {
			T1 t1 = t1EAO.persist(content);
			T2 t2 = t2EAO.persist(name);
			System.out.println(sc.getRollbackOnly());
			System.out.println(destinationServiceRemote.getAgent((byte)1));
			return new int[] { t1.getId(), t2.getId() };
		} catch (Exception e) {
			//sc.setRollbackOnly();
			throw e;
		}
	}
	
	@AfterBegin
	public void afterBegin() throws EJBException, RemoteException{
		System.out.println("AfterBegin");
	}
	
	@BeforeCompletion
	public void beforeCompletion() throws EJBException, RemoteException{
		System.out.println("beforeCompletion");
	}
	
	@AfterCompletion
	public void afterCompletion(boolean committed) throws EJBException, RemoteException{
		System.out.println("afterCompletion");
	}
}
