package io.pivotal.services.dataTx.geode.operations.stats;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;

import io.pivotal.services.dataTx.geode.operations.stats.ArchiveInfo;
import io.pivotal.services.dataTx.geode.operations.stats.GfStatsReader;
import io.pivotal.services.dataTx.geode.operations.stats.visitors.RegionCsvStatsVisitor;

import static org.junit.Assert.*;

import nyla.solutions.core.io.IO;

@Ignore
public class GfStatsReaderTest
{
	@Test
	public void testCsvs() throws Exception
	{
		//TODO: delete
		File directory = new File("src/test/resources/stats/rdrlnxm28-server1.gfs");
		GfStatsReader.toCvsFiles(directory);
		
		Set<File> gfsFiles = IO.listFileRecursive(directory, "*.gfs");
		
		assertNotNull(gfsFiles);
		assertTrue(gfsFiles.size() > 0);
		
		Set<File> csvFiles = IO.listFileRecursive(directory, "*.csv");
		
		System.out.println("files:"+csvFiles);
		assertNotNull(csvFiles);
		assertTrue(csvFiles.size() > 0);
		
	}//------------------------------------------------
	@Test
	public void testMain()
	throws Exception
	{
		String csvFilePath = "runtime/VMStats.csv";
		
		String archiveName = "src/test/resources/stats/server1.gfs";
		
		if(IO.delete(Paths.get(csvFilePath).toFile()))
		{
			System.out.println("file deleted");
		}
		
		String [] args = {archiveName,"VMStats",csvFilePath};
		GfStatsReader.main(args);
		
		File file = Paths.get(csvFilePath).toFile();
		assertTrue(file.exists());
		assertTrue(file.delete());
		
		args[1] = "VMMemoryUsageStats";
		//svFilePath = "runtime/VMStats.csv";
		
	}
	@Test
	public void testMainJustStat()
	throws Exception
	{
		
		String archiveName = "src/test/resources/stats/server1.gfs";
	
		String [] args = {archiveName};
		GfStatsReader.main(args);
		

		
	}
	@Test
	public void testDump()
	throws Exception
	{
		String archiveName = "src/test/resources/stats/server1.gfs";
		
		GfStatsReader reader = new GfStatsReader(archiveName);
		
		ArchiveInfo archiveInfo = reader.getArchiveInfo();
		
		System.out.println("archiveInfo:"+archiveInfo);
		reader.dump(new PrintWriter(System.out));
	}
	
	@Test
	public void testPrettyPRint()
	throws Exception
	{
		String archiveName = null;
		GfStatsReader reader = null;

		File file = new File("runtime/out.csv");
		file.delete();
		
		RegionCsvStatsVisitor visitor = new RegionCsvStatsVisitor(file);
		for(int i= 27; i <= 38;i++)
		{
			archiveName = "src/test/resources/stats/rdrlnxm"+i+"-server1.gfs";
			reader = new GfStatsReader(archiveName);
			reader.accept(visitor);
		}
		
		for(int i= 48; i <= 55;i++)
		{
			archiveName = "src/test/resources/stats/rdrlnxm"+i+"-server1.gfs";
			reader = new GfStatsReader(archiveName);
			reader.accept(visitor);
		}
		
		
	}

}
