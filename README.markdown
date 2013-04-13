[![Build Status](http://teamtter.com:8080/job/xml-mapping-tutorial/badge/icon)](http://teamtter.com:8080/job/xml-mapping-tutorial/)

For a more complete description, see the complete tutorial in [the Github wiki](https://github.com/fmarot/xml-mapping-tutorial/wiki)

# What is XML-mapping-tutorial ? 
Tutorial for splitting webservice generation (cxf with wsdl to Java) and xml mapping (XSD to Java) into distinct Maven projects. Uses an XML catalog.

# Content
4 maven based projects
* a parent pom project ( xml-mapping-tutorial )
* jar projects:
 * an xml to java mapping service ( mapping-service )
 * domain ( basic application domain in Java )
* a war project: sample webapp exposing a webservice and nothing else, the XML to Java mapping is delegated to the mapping-service project

# Status
It works and fills its goal. Nevertheless, many things may be improved (see TODO section below)

# TODO
* mvn tomcat/jetty plugin
* enhance the order object, Java as well as XSD ('cause having only 1 field is kinda...)
* 
