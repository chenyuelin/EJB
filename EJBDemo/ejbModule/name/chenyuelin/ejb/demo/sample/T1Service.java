package name.chenyuelin.ejb.demo.sample;

import java.rmi.RemoteException;

import javax.ejb.AfterBegin;
import javax.ejb.AfterCompletion;
import javax.ejb.BeforeCompletion;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import name.chenyuelin.ejb.demo.sample.dto.T1DTO;
import name.chenyuelin.ejb.demo.sample.eao.T1EAO;
import name.chenyuelin.ejb.demo.sample.model.T1;
import name.chenyuelin.ejb.demo.sample.transformer.Transformer;

/**
 * Session Bean implementation class T1Service
 */
@Stateless
@Remote(T1ServiceRemote.class)
public class T1Service implements T1ServiceRemote {
	@EJB
	private T1EAO t1EAO;
	
	@Override
	public T1DTO getT1(int id) {
		T1 t1=t1EAO.getT1(id);
		return Transformer.toT1DTO(t1);
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
