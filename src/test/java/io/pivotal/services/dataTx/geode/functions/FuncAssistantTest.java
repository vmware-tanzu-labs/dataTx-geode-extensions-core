package io.pivotal.services.dataTx.geode.functions;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.execute.RegionFunctionContext;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import io.pivotal.services.dataTx.geode.functions.FuncAssistant;
import io.pivotal.services.dataTx.geode.functions.JvmRegionFunctionContext;

/**
 * Test for FuncAssistant
 * @author Gregory Green
 */

public class FuncAssistantTest
{
    @Test
    public void test_getLocalPrimaryData()
    {
        Region<?, ?> region = Mockito.mock(Region.class);

        RegionFunctionContext rfc = Mockito.mock(JvmRegionFunctionContext.class);

        Region<?, ?> localPrimaryData = FuncAssistant.getLocalPrimaryData(region, rfc);

        Assert.assertNotNull(localPrimaryData);

    }
}
