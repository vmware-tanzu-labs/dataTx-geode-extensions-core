package io.pivotal.services.dataTx.geode.serialization;


import org.apache.geode.pdx.ReflectionBasedAutoSerializer;

public class EnhancedReflectionSerializer extends ReflectionBasedAutoSerializer
{
	

	public EnhancedReflectionSerializer()
	{
		super();
	}
	public EnhancedReflectionSerializer(boolean checkPortability, String... patterns)
	{
		super(checkPortability, patterns);
	}
	public EnhancedReflectionSerializer(String... patterns)
	{
		super(patterns);
	}
}
