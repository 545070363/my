package com.superbug.jvm.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理分页参数
 */
public class PageUtil {

    /**
     * 默认参数
     * @param param
     * @return
     */
    public static void pageMap(Map<String,Object> param){
        if (param.get("size") != null && param.get("no") != null) {
            int pageSize = (Integer) param.get("size");
            int pageNo = (Integer) param.get("no");
            if (pageSize != 0) {
                pageNo = pageNo == 0 ? 1 : pageNo;
                param.put("startIndex", (pageNo - 1) * pageSize);
                param.put("offSet", pageSize);
            }
        }
    }

}
