package ch03.mctx;

import java.util.Map;
import java.util.Set;
public class MapDump {
    public static void dump_map(Map map, String indent) {
       Set keys = map.keySet();
       for (Object key : keys) {
          System.out.println(indent + key + " ==> " + map.get(key));
          if (map.get(key) instanceof Map)
             dump_map((Map) map.get(key), indent += "   ");
       }
    }
}