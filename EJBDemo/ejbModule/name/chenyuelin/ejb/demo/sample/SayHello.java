package name.chenyuelin.ejb.demo.sample;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Init;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class SayHello
 */
@Stateless
@Remote(SayHelloRemote.class)
public class SayHello implements SayHelloRemote {

	@Init
	public void init(){
		System.out.println("init");
	}
	
	
	@PostConstruct
	public void construct(){
		System.out.println("construct");
	}
	
	@Override
	public String say() {
		return "Hello EveryBody!";
	}

	@PreDestroy
	public void exist(){
		System.out.println("exist");
	}
}
