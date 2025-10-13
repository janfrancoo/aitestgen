package com.janfranco.aitestgen.service;

import com.janfranco.aitestgen.model.request.AddRequest;
import com.janfranco.aitestgen.model.response.AddResponse;

public interface AddService {
    AddResponse add(AddRequest request);
}
