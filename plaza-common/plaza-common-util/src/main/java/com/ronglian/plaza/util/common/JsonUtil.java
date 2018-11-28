package com.ronglian.plaza.util.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author likui
 * @Classname: JsonUtil
 * @Description: json转换工具
 * @create 2018-09-26 16:55
 **/
public class JsonUtil {

	private static ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * 转换为json字符串
	 * @param object
	 * @return
	 */
	public static String toJson(Object object) {
		String backMsg = "";
		try {
			backMsg = objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return backMsg;
	}

	public static Object fromJson(String message, TypeReference typeReference){
        try {
            return objectMapper.readValue(message,typeReference);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
