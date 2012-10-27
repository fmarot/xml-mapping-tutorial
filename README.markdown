# What is XML-mapping-tutorial ? 
Tutorial for splitting webservice generation and xml mapping into distinct projects. Uses an XML catalog.
XML mapping tutorial is not a general-purpose XML mapping tutorial (!). It's aim is to demonstrate how to separate the web-service project from the XML-to-java mapping part.

# Content
4 maven based projects
* a parent pom project ( xml-mapping-tutorial )
* jar projects:
** an xml to java mapping service ( mapping-service )
** domain ( basic application domain in Java )
* a war project: sample webapp exposing a webservice and nothing else, the mapping is delegated to the mapping-service project

# Status
It works and fills its goal. Nevertheless, many things may be improved (see TODO section below)

# TODO
A *LOT* of stuffs !
* clean the POMs (version numbers in parent)
* mvn tomcat/jetty plugin