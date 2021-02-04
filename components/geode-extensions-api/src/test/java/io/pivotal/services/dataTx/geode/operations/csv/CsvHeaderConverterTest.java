package io.pivotal.services.dataTx.geode.operations.csv;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import io.pivotal.services.dataTx.geode.demo.SimpleObject;
import io.pivotal.services.dataTx.geode.operations.csv.CsvHeaderConverter;
import nyla.solutions.core.patterns.creational.generator.JavaBeanGeneratorCreator;

public class CsvHeaderConverterTest
{

	@Test
	public void testConvert()
	{
		CsvHeaderConverter c = new CsvHeaderConverter();
		
		assertEquals("\"\"\n",c.convert(null));
		assertEquals(String.class.getSimpleName()+"\n",c.convert(""));
		
		JavaBeanGeneratorCreator<SimpleObject> factory = new JavaBeanGeneratorCreator<>(SimpleObject.class);
		
		SimpleObject so = factory.create();
		
		String out = c.convert(so);
		
		System.out.println("out:"+out);
		
		assertNotNull(out);

	}

}
