package org.lemonpzl.weixin.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.lemonpzl.weixin.domain.InMessage;
import org.lemonpzl.weixin.domain.event.EventInMessage;
import org.lemonpzl.weixin.domain.image.ImageInMessage;
import org.lemonpzl.weixin.domain.link.LinkInMessage;
import org.lemonpzl.weixin.domain.location.LocationInMessage;
import org.lemonpzl.weixin.domain.shortvideo.ShortvideoInMessage;
import org.lemonpzl.weixin.domain.text.TextInMessage;
import org.lemonpzl.weixin.domain.video.VideoInMessage;
import org.lemonpzl.weixin.domain.voice.VoiceInMessage;

public class MessageTypeMapper {
	
	private static Map<String, Class<? extends InMessage>> typeMap = new ConcurrentHashMap<>();

	// 通过一个Map记录了消息类型和类的关系
	static {
		typeMap.put("text", TextInMessage.class);
		typeMap.put("image", ImageInMessage.class);

		typeMap.put("voice", VoiceInMessage.class);
		typeMap.put("video", VideoInMessage.class);
		typeMap.put("location", LocationInMessage.class);
		typeMap.put("shortvideo", ShortvideoInMessage.class);
		typeMap.put("link", LinkInMessage.class);
		
		typeMap.put("event", EventInMessage.class);

		// typeMap.put("event", EventInMessage.class);
	}

	// 通过消息类型获取对应的类
	@SuppressWarnings("unchecked")
	public static <T extends InMessage> Class<T> getClass(String type) {
		return (Class<T>) typeMap.get(type);
	}

}
