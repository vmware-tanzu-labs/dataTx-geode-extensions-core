package io.pivotal.services.dataTx.geode.operations.config;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import io.pivotal.services.dataTx.geode.operations.config.ConvertCacheXml2GfshScript;

public class ConvertCacheXml2GfshScriptTest
{

	@Test
	public void testNoArgs() throws Exception
	{
		String[] args = {};
		
		try 
		{
			ConvertCacheXml2GfshScript.main(args);
			fail();
		}
		catch(IllegalArgumentException e)
		{
			
		}
	}
	
	@Test
	public void testMain()
	{
		String[] args = {"src/test/resources/xml/clusterCopy.xml"};
		
		ConvertCacheXml2GfshScript.main(args);
	}

}
