package com.example.iceCream.Controllers;

import com.example.iceCream.Services.IceCreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ice_cream/")
public class IceCreamController {
    @Autowired
    private final IceCreamService iceCreamService;

    public IceCreamController(IceCreamService iceCreamService) {
        this.iceCreamService = iceCreamService;
    }


}
