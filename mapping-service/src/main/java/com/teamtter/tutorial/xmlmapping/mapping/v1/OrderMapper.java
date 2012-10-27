package com.teamtter.tutorial.xmlmapping.mapping.v1;

import java.net.URL;

import javax.xml.bind.Unmarshaller;

import lombok.extern.slf4j.Slf4j;

import com.teamtter.tutorial.xmlmapping.Order;
import com.teamtter.tutorial.xmlmapping.util.UnmarshallerWrapper;
import com.teamtter.tutorial.xmlmapping.xsd.order.v1.OrderType;
import com.teamtter.tutorial.xmlmapping.xsd.order.v1.OrderWrapper;

@Slf4j
public class OrderMapper {

	/** WARNING: not thread safe (FIXME ?) */
	private static Unmarshaller unmarshaller;

	public OrderMapper() {
		unmarshaller = UnmarshallerWrapper.getUnmarschaller_v1();
	}

	/** WARNING: method is not thread safe (FIXME ?) */
	public Order convertToJavaOrder(String xmlOrderFileLocation)
			throws Exception {
		URL xmlOrderUrl = getClass().getResource(xmlOrderFileLocation);
		Object unmarschalled = unmarshaller.unmarshal(xmlOrderUrl);
		OrderWrapper orderWrapper = (OrderWrapper) unmarschalled;
		return convertToJavaOrder(orderWrapper.getOrder());
	}

	/** called by the webservice to do the mapping */
	public Order convertToJavaOrder(OrderType xmlOrder) throws Exception {
		Order javaOrder = new Order();
		String xmlOrderNumber = xmlOrder.getOrderNumber();
		javaOrder.setOrderNumber(xmlOrderNumber);
		return javaOrder;
	}

}
