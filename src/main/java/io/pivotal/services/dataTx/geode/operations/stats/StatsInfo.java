package io.pivotal.services.dataTx.geode.operations.stats;

import io.pivotal.services.dataTx.geode.operations.stats.visitors.StatsVisitor;

public interface StatsInfo
{

	void accept(StatsVisitor visitor);
}
