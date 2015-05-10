package name.chenyuelin.ejb.demo2.sample;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
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
public class DestinationService implements DestinationServiceRemote {
	@EJB
	private AgentEAO agentEAO;

	public AgentDTO getAgent(byte id){
		return AgentTransformer.toAgentDTO(agentEAO.getAgent(id));
	}
	
	public AgentDTO createAgent(String name){
		return AgentTransformer.toAgentDTO(agentEAO.persist(name));
	}
}
