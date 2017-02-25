package cn.arunner.zhixue.utils;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;



public class Wisdom {
	//private static Map<String, String> map = new HashMap<String, String>();
	private static Map<Integer, String> map = new HashMap<Integer, String>();
	
	@Test
	public static void setMap() {
		System.out.println("setMap方法执行了");
		map.put(1, "张嘉佳#时间一直向前走，没有尽头，只有路口");
		map.put(2, "马云#这世界上没有优秀的理念，只有脚踏实地的结果");
		map.put(3, "雨果#一片树叶受到阳关照耀，它的背面一定是阴影，阳光越亮，阴影越深");
		map.put(4, "王维#一身转战三千里，一剑曾当百万师");
		map.put(5, "毕淑敏#无论这个世界对你怎样，都请你一如既往的努力、勇敢、充满希望");
		map.put(6, "马丁·路德·金#如果你的梦想还站着的话，那么没有人能使你倒下");
		map.put(7, "科比·比恩·布莱恩特#如果你害怕失败，那意味着你已经输了");
		map.put(8, "萧伯纳#人生有两出悲剧。一是万念俱灰；另一是踌躇满志");
		map.put(9, "村上春树#活着就意味必须要做点什么，请好好努力");
		map.put(10, "林夕#跌到了最暗处，心忽然明了");
		
		
		/*Properties properties = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream("src/wisdom.properties"));
			properties.load(in);
			Iterator<String> iterator = properties.stringPropertyNames().iterator();
			while(iterator.hasNext()) {
				String key = iterator.next();
				String value = properties.getProperty(key);
				value = new String(value.getBytes("ISO-8859-1"),"UTF-8");
				System.out.println(key + "===" + value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
	}
	
	
	/*public static void main(String[] args) {
		Properties properties = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream("src/wisdom.properties"));
			properties.load(in);
			Iterator<String> iterator = properties.stringPropertyNames().iterator();
			while(iterator.hasNext()) {
				String key = iterator.next();
				String value = properties.getProperty(key);
				value = new String(value.getBytes("ISO-8859-1"),"UTF-8");
				System.out.println(key + "===" + value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	
	public static String getWisdom() {
		//执行方法,为map集合赋值
		if (map.isEmpty()) {
			setMap();
		}
		//生成随机数key,来得到value,并返回value
		int key = (int)(Math.random() * 10) + 1;
		String value = map.get(key);
		return value;
	}
}
