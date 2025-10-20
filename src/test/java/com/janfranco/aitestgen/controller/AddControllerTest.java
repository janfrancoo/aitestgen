package com.janfranco.aitestgen.controller;

import com.janfranco.aitestgen.model.request.AddRequest;
import com.janfranco.aitestgen.model.response.AddResponse;
import com.janfranco.aitestgen.service.AddService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class AddControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private AddService addService;

    @InjectMocks
    private AddController addController;

    @Test
    public void testAdd() throws Exception {
        AddRequest request = new AddRequest();
        request.setValue1(5);
        request.setValue2(10);
        
        AddResponse response = new AddResponse(15);
        
        when(addService.add(request)).thenReturn(response);
        
        mockMvc.perform(post("/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(15));
    }
}