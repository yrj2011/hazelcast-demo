package org.palm.hazelcast.map.store;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Map;

import com.hazelcast.config.ClasspathXmlConfig;
import com.hazelcast.config.Config;
import com.hazelcast.config.FileSystemXmlConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class MapStoreExampleMain {
	public static void main(String[] args) throws FileNotFoundException {
	    System.out.println("start date :" + new Date());
		//加载配置
		//Config config = new ClasspathXmlConfig("org/palm/hazelcast/map/store/mapStoreConfig.xml");
		Config config = new FileSystemXmlConfig("D:\\workspace-2019-3-5\\workspace\\hazelcast-demo\\src\\main\\java\\org\\palm\\hazelcast\\map\\store\\mapStoreConfig.xml");

		//创建Hazelcast实力
		HazelcastInstance ins = Hazelcast.newHazelcastInstance(config);
		//获取Map
		Map<Integer, String> map = ins.getMap("demo");
		println(map.get(1));//输出第一条数据
		
		map.put(11, "Moonbrook");//添加一条数据
		println(map.get(11));//输出第一条数据

		map.put(11, "Moonbrook");//添加一条数据

		map.put(12, "Moonbrook1");//添加一条数据

		map.put(13, "Moonbrook2");//添加一条数据

		map.remove(11);//移除添加的数据
		println(map.get(11));//输出被移除的数据
	}
	
	static private void println(Object obj){
		System.out.println(obj);
	}
}
