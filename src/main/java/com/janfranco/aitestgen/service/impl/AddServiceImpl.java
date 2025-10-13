package com.janfranco.aitestgen.service.impl;

import com.janfranco.aitestgen.model.request.AddRequest;
import com.janfranco.aitestgen.model.response.AddResponse;
import com.janfranco.aitestgen.service.AddService;
import org.springframework.stereotype.Service;

@Service
public class AddServiceImpl implements AddService {
    @Override
    public AddResponse add(AddRequest request) {
        return new AddResponse(request.getValue1() + request.getValue2());
    }
}
