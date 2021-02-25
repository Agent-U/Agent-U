package com.agentu_api.controller;

import com.agentu_api.service.AgentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

public class AgentControllerTest {

    @Mock
    private AgentService agentService;

    @InjectMocks
    private AgentController agentController;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllAgents_shouldCallTheService() {
        agentController.getAllAgents();

        verify(agentService).getAllAgents();
    }



    @Test
    void agentController_shouldBeAnnotated(){
        RestController controllerAnnotation =
                AgentController.class.getAnnotation(RestController.class);
        assertNotNull(controllerAnnotation);

        RequestMapping requestMappingAnnotation =
                AgentController.class.getAnnotation(RequestMapping.class);
        assertArrayEquals(new String[]{"/agents"}, requestMappingAnnotation.value());
    }

    @Test
    void getAllTrainers_shouldBeAnnotated() throws NoSuchMethodException {
        Method getAllTrainers = AgentController.class.getDeclaredMethod("getAllAgents");
        GetMapping getMapping = getAllTrainers.getAnnotation(GetMapping.class);

        assertNotNull(getMapping);
        assertArrayEquals(new String[]{"/"}, getMapping.value());
    }

    @Test
    void getAgent_shouldBeAnnotated() throws NoSuchMethodException {
        Method getAgent =
                AgentController.class.getDeclaredMethod("getAgent", Long.class);
        GetMapping getMapping = getAgent.getAnnotation(GetMapping.class);

        assertNotNull(getMapping);
        assertArrayEquals(new String[]{"/{id}"}, getMapping.value());

    }
}
