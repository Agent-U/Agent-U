package com.agentu_api.bo;

import org.junit.jupiter.api.Test;

import javax.persistence.*;

import static org.junit.jupiter.api.Assertions.*;

public class AgentTest {

    @Test
    void agent_doitEtreEntity(){
        assertNotNull(Agent.class.getAnnotation(Entity.class));
    }

    @Test
    void agentId_doitEtreId() throws NoSuchFieldException {
        assertNotNull(Agent.class.getDeclaredField("id").getAnnotation(Id.class));
    }

}