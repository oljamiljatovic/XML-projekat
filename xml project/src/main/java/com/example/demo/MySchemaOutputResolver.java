package com.example.demo;

import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.stream.StreamResult;

public class MySchemaOutputResolver extends SchemaOutputResolver {
	    private StringWriter stringWriter = new StringWriter();    

	    public javax.xml.transform.Result createOutput(String namespaceURI, String suggestedFileName) throws IOException  {
	        StreamResult result = new StreamResult(stringWriter);
	        result.setSystemId(suggestedFileName);
	        return result;
	    }

	    public String getSchema() {
	        return stringWriter.toString();
	    }

	
}
