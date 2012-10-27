package com.teamtter.tutorial.xmlmapping.mapping.v1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.teamtter.tutorial.xmlmapping.Order;
import com.teamtter.tutorial.xmlmapping.mapping.v1.OrderMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath*:order-frame-mapping-serviceTest-applicationContext.xml"
})
public class TestUnmarschallOrderMapper {
    
    @Autowired
    private OrderMapper orderMapper_V1;
    
    @Test
    public void testConvertXMLFilesToEcomOrderV5_3() throws Exception {
    	String xmlOrderFileLocation = "/order_V1.xml";
        Order order = orderMapper_V1.convertToJavaOrder(xmlOrderFileLocation);
        
        Assert.assertEquals(order.getOrderNumber(), "TOTO");
    }
    
}

