package com.janfranco.aitestgen.controller;

import com.janfranco.aitestgen.model.request.AddRequest;
import com.janfranco.aitestgen.model.response.AddResponse;
import com.janfranco.aitestgen.service.AddService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class AddControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AddService addService;

    @Test
    public void testAdd() throws Exception {
        AddRequest request = new AddRequest();
        request.setValue1(5);
        request.setValue2(10);
        
        Mockito.when(addService.add(Mockito.any(AddRequest.class))).thenReturn(new AddResponse(15));
        
        mockMvc.perform(post("/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"value1\":5,\"value2\":10}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(15));
    }
}