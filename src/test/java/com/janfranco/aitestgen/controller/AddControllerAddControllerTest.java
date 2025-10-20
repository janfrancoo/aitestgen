```java
package com.janfranco.aitestgen;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.janfranco.aitestgen.model.request.AddRequest;
import com.janfranco.aitestgen.model.response.AddResponse;
import com.janfranco.aitestgen.service.AddService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class AddControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AddService addService;

    @Test
    public void testAdd() throws Exception {
        AddRequest request = new AddRequest();
        request.setValue1(5);
        request.setValue2(3);
        AddResponse response = new AddResponse(8);

        when(addService.add(any(AddRequest.class))).thenReturn(response);

        MockHttpServletResponse result = mockMvc.perform(post("/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(8))
                .andReturn()
                .getResponse();
    }
}
```