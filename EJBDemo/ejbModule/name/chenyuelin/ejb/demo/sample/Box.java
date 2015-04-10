package name.chenyuelin.ejb.demo.sample;

import java.io.Serializable;
import java.rmi.RemoteException;

import javax.ejb.AfterBegin;
import javax.ejb.BeforeCompletion;
import javax.ejb.EJBException;
import javax.ejb.Remote;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class Box
 */
@Stateful
@Remote(BoxRemote.class)
public class Box implements BoxRemote,Serializable {

	private static final long serialVersionUID = -5041070812564756885L;
	
	private int count=0;
	
    /**
     * Default constructor. 
     */
    public Box() {
        System.out.println("I'm box");
    }

	@Override
	public void add(int i) {
		count+=i;
	}

	@Override
	public String showStatus() {
		return "Box [count=" + count + "]";
	}

	@AfterBegin
	public void afterBegin() throws EJBException, RemoteException{
		System.out.println("AfterBegin");
	}
	
	@BeforeCompletion
	public void beforeCompletion() throws EJBException, RemoteException{
		System.out.println("beforeCompletion");
	}
	
	public void afterCompletion(boolean committed) throws EJBException, RemoteException{
		System.out.println("afterCompletion");
	}
}
