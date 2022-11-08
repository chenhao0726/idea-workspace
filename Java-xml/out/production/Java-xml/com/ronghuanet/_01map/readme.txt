Map 一个容器.存放键值对,是一个接口
	|- HashMap: 无序,只能存放一个相同的key,key可以为null,value可以为null;不同步(线程不安全)
		|- LinkedHashMap:有序 
	|- HashTable:同步的map 但是key和value都不允许为null,无序
		|- Properties:它的键值对都是能是String类型
	|- TreeMap:排序 自然排序/定制排序 返回正数 升序 返回负数降序,返回0 相等
	|- ConcurrentHashMap:线程安全的HashMap
	