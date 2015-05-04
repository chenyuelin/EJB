package name.chenyuelin.ejb.demo.sample.eao;

import java.rmi.RemoteException;

import javax.ejb.AfterBegin;
import javax.ejb.AfterCompletion;
import javax.ejb.BeforeCompletion;
import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import name.chenyuelin.ejb.demo.sample.model2.T2;

/**
 * Session Bean implementation class T2EAO
 */
@Stateless
@LocalBean
public class T2EAO {

	@PersistenceContext(unitName="JPATestDB2")
    private EntityManager em;

	public T2 getT2(int id){
		return em.find(T2.class, (byte)id);
	}
	public T2 persist(String name){
		T2 t2=new T2();
		t2.setName(name);
		em.persist(t2);
		em.flush();
		return t2;
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
