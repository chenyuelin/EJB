package name.chenyuelin.ejb.demo2.sample;

import name.chenyuelin.ejb.demo2.sample.dto.AgentDTO;
import name.chenyuelin.ejb.demo2.sample.model3.Agent;

public class AgentTransformer {
	public static AgentDTO toAgentDTO(Agent agent){
		if(agent==null){
			return null;
		}
		AgentDTO dto=new AgentDTO();
		dto.setId(agent.getId());
		dto.setName(agent.getName());
		return dto;
	}
}
