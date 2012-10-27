package com.teamtter.tutorial.xmlmapping.util;

import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UnmarshallerWrapper {

	@Getter
	private static Unmarshaller unmarschaller_v1 = createUnmarschaller("xsd/types/v1/orderType.xsd",
			com.teamtter.tutorial.xmlmapping.xsd.order.v1.OrderType.class);

	// Private constructor prevents instantiation from other classes
	private UnmarshallerWrapper() {
	}

	/** @return an Unmarshaller able to unmarschal xml conforming to the given
	 *         schema an returning an instance of the given class */
	private static Unmarshaller createUnmarschaller(String xsdLocationAsResource, Class clazz) {
		Unmarshaller unmarshaller = null;
		try {
			log.info("XSD location used to init unmarschaller: {}", xsdLocationAsResource);
			// warning, the following line will not work if the method is not static
			URL resourceUrl = UnmarshallerWrapper.class.getClassLoader().getResource(xsdLocationAsResource);
			log.info("URL of the XSD unmarschaller file: {}", resourceUrl);

			SchemaFactory schemaFactoryInstance = SchemaFactory
					.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = schemaFactoryInstance.newSchema(resourceUrl);

			String packageName = clazz.getPackage().getName();
			JAXBContext jaxbc = JAXBContext.newInstance(packageName);
			unmarshaller = jaxbc.createUnmarshaller();
			unmarshaller.setSchema(schema);

			log.info("Created unmarschaller for {}", xsdLocationAsResource);
		} catch (Exception e) {
			log.error("Unable to init unmarschaller... Any attempt to map order WILL FAIL...", e);
		}
		return unmarshaller;
	}

}
