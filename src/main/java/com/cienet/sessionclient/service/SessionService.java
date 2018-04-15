package com.cienet.sessionclient.service;

import com.cienet.sessionclient.entity.DeliverySessionCreationType;

/**
 * @program: session-client
 * @description: 回话相关操作
 * @author: SunWei
 * @create: 2018-04-15 14:19
 **/
public interface SessionService {

    String  deliverysession(long deliverySessionId);

    Boolean SessionStart(long deliverySessionId);

    Boolean SessionStop(long deliverySessionId);

}
