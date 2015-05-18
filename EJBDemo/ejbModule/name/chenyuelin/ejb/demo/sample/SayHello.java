package name.chenyuelin.ejb.demo.sample;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import org.jboss.logging.Logger;

/**
 * Session Bean implementation class SayHello
 */
@Stateless
@Remote(SayHelloRemote.class)
public class SayHello implements SayHelloRemote {
	private static final Logger LOGGER=Logger.getLogger(SayHello.class);
	
	@Resource
	private SessionContext sessionContext;
	
	@PostConstruct
	public void construct(){
		System.out.println("construct");
	}
	
	@Override
	public String say() {
		LOGGER.debug("say start.");
		return "Hello EveryBody!";
	}

	@PreDestroy
	public void exist(){
		System.out.println("exist");
	}
	
	@Remove
	public void close(){
		System.out.println("Remove");
	}
}
