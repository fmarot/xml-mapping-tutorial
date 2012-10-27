package com.teamtter.ws.orderinjector.v1;

import lombok.extern.slf4j.Slf4j;

import com.teamtter.tutorial.xmlmapping.Order;
import com.teamtter.tutorial.xmlmapping.mapping.v1.OrderMapper;
import com.teamtter.tutorial.xmlmapping.ws.orderinjector.v1.InjectOrderRequest;
import com.teamtter.tutorial.xmlmapping.ws.orderinjector.v1.InjectOrderResponse;
import com.teamtter.tutorial.xmlmapping.ws.orderinjector.v1.OrderInjectorFaultMsg;
import com.teamtter.tutorial.xmlmapping.ws.orderinjector.v1.OrderInjectorPortType;
import com.teamtter.tutorial.xmlmapping.xsd.order.v1.OrderType;

@Slf4j
public class OrderInjectorService_V1 implements OrderInjectorPortType {
	
	private OrderMapper ordermapper = new OrderMapper();
	
	@Override
	public InjectOrderResponse injectOrder(InjectOrderRequest injectOrderResquest) throws OrderInjectorFaultMsg {
		InjectOrderResponse response = new InjectOrderResponse();
		try {
			// Mapping de la commande
			OrderType xmlOrder = injectOrderResquest.getOrder();
			Order order = ordermapper.convertToJavaOrder(xmlOrder);

			// Initialisation de la reponse
			response.setOrderNumber(order.getOrderNumber());
		} catch (Exception e) {
			log.error("Error while injecting order", e);
			throw new OrderInjectorFaultMsg(e.getMessage(), e);
		}

		return response;
	}

}
