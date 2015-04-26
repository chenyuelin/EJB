package name.chenyuelin.ejb.demo.sample.eao;

import java.rmi.RemoteException;

import javax.ejb.AfterBegin;
import javax.ejb.AfterCompletion;
import javax.ejb.BeforeCompletion;
import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import name.chenyuelin.ejb.demo.sample.model.T1;

/**
 * Session Bean implementation class T1EAO
 */
@Stateful
@LocalBean
public class T1EAO {

	@PersistenceContext(unitName="JPATestDB",type=PersistenceContextType.EXTENDED)
    private EntityManager em;

	public T1 getT1(int id){
		return em.find(T1.class, (byte)id);
	}
	
	public T1 persist(String content){
		T1 t1=new T1();
		t1.setContent(content);
		em.persist(t1);
		em.flush();
		return t1;
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
