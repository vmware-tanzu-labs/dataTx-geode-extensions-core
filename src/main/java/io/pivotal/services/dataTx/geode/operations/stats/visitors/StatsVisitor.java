package io.pivotal.services.dataTx.geode.operations.stats.visitors;

import io.pivotal.services.dataTx.geode.operations.stats.ArchiveInfo;
import io.pivotal.services.dataTx.geode.operations.stats.ResourceInst;
import io.pivotal.services.dataTx.geode.operations.stats.ResourceType;
import io.pivotal.services.dataTx.geode.operations.stats.SimpleValue;
import io.pivotal.services.dataTx.geode.operations.stats.TimeStampSeries;

public interface StatsVisitor
{

	default  void visitArchInfo(ArchiveInfo archiveInfo){}
	
	default void visitResourceType(ResourceType resourceType){}
	
	default  void visitTimeStampSeries(TimeStampSeries timeStampSeries){}
	default void visitResourceInsts(ResourceInst[] resourceInsts){}
	default void visitResourceInst(ResourceInst resourceInst){}
	default void visitSimpleValue(SimpleValue simpleValue) {}
}
