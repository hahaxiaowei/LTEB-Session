package com.cienet.sessionclient.controller;

import com.cienet.sessionclient.entity.DeliverySessionCreationType;
import com.cienet.sessionclient.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: session-client
 * @description: controller层，书写请求接口
 * @author: SunWei
 * @create: 2018-04-15 15:40
 **/
@RestController
@RequestMapping(value = "/nbi")
public class SessionController {

    @Autowired
    SessionService sessionService;

    /**
     * @Description:
     * @Param: [deliverySessionId]
     * @return: java.lang.String
     * @Author: Mr.Wang
     * @Date: 2018/4/15
     */
    @RequestMapping(value = "deliverysession",method = RequestMethod.POST)
    public String deliverysession(@PathVariable(value = "deliverySessionId") long deliverySessionId){

        return sessionService.deliverysession(deliverySessionId);
    }
}
