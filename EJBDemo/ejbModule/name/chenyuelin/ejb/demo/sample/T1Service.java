package name.chenyuelin.ejb.demo.sample;

import javax.ejb.EJB;
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


}
