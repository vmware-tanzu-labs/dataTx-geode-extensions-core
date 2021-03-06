package io.pivotal.services.dataTx.geode.functions;

import java.util.Set;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.execute.Execution;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import io.pivotal.services.dataTx.geode.functions.JvmExecution;

/**
 * @author Gregory Green testing JvmExecution
 */
public class JvmExecutionTest {

    @SuppressWarnings("unchecked")
	@Test
    public void test_withFilter(){

        Region<Object,Object> region = Mockito.mock(Region.class);
        JvmExecution<?,?,?> jvm = new JvmExecution<Object,Object,Object>(region);

        Set<?> set = Mockito.mock(Set.class);
        Execution<?,?,?> exe = jvm.withFilter(set);

        Assert.assertEquals(jvm,exe);

    }

    @SuppressWarnings("unchecked")
	@Test
    public void test_withArgs(){

        Region<Object,Object> region = Mockito.mock(Region.class);
        JvmExecution<?,?,?> jvm = new JvmExecution<Object,Object,Object>(region);

        Execution<?,?,?> exe = jvm.withArgs("");

        Assert.assertEquals(jvm,exe); 

    }
}
