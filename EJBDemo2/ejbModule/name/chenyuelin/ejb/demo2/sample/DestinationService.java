package name.chenyuelin.ejb.demo2.sample;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import name.chenyuelin.ejb.demo2.sample.dto.AgentDTO;
import name.chenyuelin.ejb.demo2.sample.eao.AgentEAO;

/**
 * Session Bean implementation class DestinationService
 */
@Stateless
@Remote(DestinationServiceRemote.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class DestinationService implements DestinationServiceRemote {
	@EJB
	private AgentEAO agentEAO;

	public AgentDTO getAgent(byte id){
		return AgentTransformer.toAgentDTO(agentEAO.getAgent(id));
	}
	
	public AgentDTO createAgent(String name){
		return AgentTransformer.toAgentDTO(agentEAO.persist(name));
	}
	
	public boolean updateAgent(byte id, String name){
		return agentEAO.update(id, name);
	}
}
