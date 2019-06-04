package io.pivotal.services.dataTx.geode.serialization;

import static org.junit.Assert.*;

import org.apache.geode.pdx.PdxInstance;
import org.junit.Ignore;
import org.junit.Test;

import io.pivotal.services.dataTx.geode.client.GeodeClient;
import io.pivotal.services.dataTx.geode.serialization.PDX;
import nyla.solutions.core.io.IO;

@Ignore
public class PDXTest
{

	@Test
	public void testFromJSON()
	throws Exception
	{
		GeodeClient.connect();
		
		String json = IO.readFile("src/test/resources/json/object.json");
		PdxInstance pdx = PDX.fromJSON(json);
		
		assertNotNull(pdx);
		
		
	}

}
