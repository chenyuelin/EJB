package name.chenyuelin.ejb.demo.sample;

import java.rmi.RemoteException;

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

import name.chenyuelin.ejb.demo.sample.eao.T1EAO;
import name.chenyuelin.ejb.demo.sample.eao.T2EAO;
import name.chenyuelin.ejb.demo.sample.model.T1;
import name.chenyuelin.ejb.demo.sample.model2.T2;

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

	@EJB
	private T1EAO t1EAO;

	@EJB
	private T2EAO t2EAO;

	public int[] persist(String content, String name) throws Exception{
		try {
			T1 t1 = t1EAO.persist(content);
			T2 t2 = t2EAO.persist(name);
			System.out.println(sc.getRollbackOnly());
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
