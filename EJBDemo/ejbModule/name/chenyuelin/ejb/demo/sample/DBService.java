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
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.naming.Context;
import javax.transaction.TransactionManager;

import name.chenyuelin.ejb.demo.sample.eao.T1EAO;
import name.chenyuelin.ejb.demo.sample.eao.T2EAO;
import name.chenyuelin.ejb.demo.sample.model.T1;
import name.chenyuelin.ejb.demo.sample.model2.T2;
import name.chenyuelin.ejb.demo2.sample.DestinationServiceRemote;

import org.jboss.logging.Logger;

/**
 * Session Bean implementation class DBService
 */
@Stateless
@Remote(DBServiceRemote.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)

@WebService
@SOAPBinding(style=Style.DOCUMENT,use=Use.ENCODED)
public class DBService implements DBServiceRemote {
	private static final Logger LOGGER=Logger.getLogger(DBService.class);
	
	@Resource
	private SessionContext sc;

	@EJB(lookup="ejb:EJBDemoEAR2/EJBDemo2/DestinationService!name.chenyuelin.ejb.demo2.sample.DestinationServiceRemote")
	private DestinationServiceRemote destinationServiceRemote;
	
	@EJB
	private T1EAO t1EAO;

	@EJB
	private T2EAO t2EAO;

	public int[] persist(String content, String name,byte id,String aname) throws Exception{
		LOGGER.info("persist start.");
		try {
			
			T2 t2 = t2EAO.persist(name);
			T1 t1 = t1EAO.persist(content);
			System.out.println(destinationServiceRemote.updateAgent(id, aname));
			sc.setRollbackOnly();
			System.out.println(sc.getRollbackOnly());
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
