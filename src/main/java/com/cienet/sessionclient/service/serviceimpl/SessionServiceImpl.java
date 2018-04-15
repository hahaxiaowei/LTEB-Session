package com.cienet.sessionclient.service.serviceimpl;

import com.cienet.sessionclient.entity.ActionType;
import com.cienet.sessionclient.entity.DeliverySessionCreationType;
import com.cienet.sessionclient.entity.ObjectFactory;
import com.cienet.sessionclient.service.SessionService;
import com.cienet.sessionclient.utils.HttpClientUtil;
import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBElement;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: session-client
 * @description: SessionService实现类
 * @author: SunWei
 * @create: 2018-04-15 14:20
 **/
@Service
public class SessionServiceImpl implements SessionService {
    private final Logger logger = LoggerFactory.getLogger(SessionService.class);

    private final static String url = "http://111.231.207.133:8801";
    @Override
    public String deliverysession(long deliverySessionId) {
        String httpEntityContent = "";
        try {
            ObjectFactory objectFactory = new ObjectFactory();
            DeliverySessionCreationType deliverySessionCreationType = objectFactory.createDeliverySessionCreationType();
            deliverySessionCreationType.setDeliverySessionId(deliverySessionId);
            deliverySessionCreationType.setAction(ActionType.START);
            deliverySessionCreationType.setVersion("1.0");
            Map<String, String> map = new HashMap<String, String>();
            map.put("deliverySessionId", String.valueOf(deliverySessionCreationType.getDeliverySessionId()));
            map.put("action", deliverySessionCreationType.getAction().value());
            map.put("version", deliverySessionCreationType.getVersion());
            httpEntityContent=HttpClientUtil.postPayMsg(url, map);
        }catch (Exception e){
            logger.error("deliverysession方法执行出错", e);
            throw new RuntimeException(e);
        }
        return httpEntityContent;
    }

    @Override
    public Boolean SessionStart(long SesssionId) {
        return null;
    }

    @Override
    public Boolean SessionStop(long SessionId) {
        return null;
    }
}
