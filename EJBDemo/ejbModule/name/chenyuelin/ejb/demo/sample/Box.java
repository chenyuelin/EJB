package name.chenyuelin.ejb.demo.sample;

import java.io.Serializable;
import java.rmi.RemoteException;

import javax.ejb.AfterBegin;
import javax.ejb.BeforeCompletion;
import javax.ejb.EJBException;
import javax.ejb.Init;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remote;
import javax.ejb.Remove;
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

    @Init
	public void init(){
		System.out.println("init");
	}
    
	@Override
	public void add(int i) {
		count+=i;
	}

	@Override
	public String showStatus() {
		return "Box [count=" + count + "]";
	}

	@PostActivate
	public void postActivate(){
		System.out.println("postActivate");
	}
	
	@PrePassivate
	public void prePassivate(){
		System.out.println("prePassivate");
	}
	
	@Remove
	@Override
	public void remove(){
		System.out.println("Will remove.");
	}
	
	//*********** SessionSynchronization *******************************
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
