package io.pivotal.services.dataTx.geode.client;

import org.apache.geode.cache.client.PoolFactory;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

/**
 * Test for PoolFactoryBuilder
 * @author Gregory Green
 */
public class PoolFactoryBuilderTest
{
    @Test
    public void test_building_factory()
    {
        PoolFactory f = mock(PoolFactory.class);
        PoolFactoryBuilder b = new PoolFactoryBuilder(f);

        b.addHostPort("host",10034);
        b.addHostPort("host2",10034);

        verify(f, Mockito.atLeast(2)).addLocator(anyString(),anyInt());

    }
}