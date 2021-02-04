package io.pivotal.services.dataTx.geode.qa.performance;

import nyla.solutions.core.operations.performance.BenchMarker;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PdxJsonPerfTest
{
    @Test
    void perftest()
    throws InterruptedException
    {
        PdxJsonPutPerfRunner r = mock(PdxJsonPutPerfRunner.class);

        BenchMarker benchMarker = mock(BenchMarker.class);
        Consumer<Number> mockConsumer = mock(Consumer.class);
        PdxJsonPerf perf = new PdxJsonPerf(benchMarker,r,mockConsumer);

        perf.runPerTest();

        verify(benchMarker).measure(r,mockConsumer);

    }
}