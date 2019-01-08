package com.hc.rest.controller.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hc.rest.entity.room.ItripImage;
import com.hc.rest.service.comment.ItripImageService;
import com.hc.rest.utils.Result;

@RestController
public class ItripImageController {

    @Autowired
    ItripImageService itripImageService;
    
    @RequestMapping(value = "/info/saveImage")
    public Result<ItripImage> save(ItripImage itripImage){
	return itripImageService.save(itripImage);
    }
}
