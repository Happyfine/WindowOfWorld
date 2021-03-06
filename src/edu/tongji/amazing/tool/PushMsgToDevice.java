package edu.tongji.amazing.tool;

import net.sf.json.JSONObject;

import org.junit.Test;
import org.springframework.stereotype.Component;

import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;
import com.baidu.yun.push.auth.PushKeyPair;
import com.baidu.yun.push.client.BaiduPushClient;
import com.baidu.yun.push.constants.BaiduPushConstants;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.model.PushMsgToSingleDeviceRequest;
import com.baidu.yun.push.model.PushMsgToSingleDeviceResponse;
@Component("sendinfo")
public class PushMsgToDevice {
	
	//type 1:barrage 2:individuation 3:advertisements
	public void send(String channelid,Object ob,String type) throws PushClientException,
			PushServerException {
		if(channelid.equals("")){
			return;
		}
		if(ob==null){
			return;
		}
		if(!type.equals("1")&&!type.equals("2")&&!type.equals("3")){
			return;
		}
		// 1. get apiKey and secretKey from developer console
		String apiKey = Defined.Baiduapk;
		String secretKey = "UPMlWj1SDcEHFsO6SdgPzmyzBKxFdgwe";
		PushKeyPair pair = new PushKeyPair(apiKey, secretKey);

		// 2. build a BaidupushClient object to access released interfaces
		BaiduPushClient pushClient = new BaiduPushClient(pair,
				BaiduPushConstants.CHANNEL_REST_URL);

		// 3. register a YunLogHandler to get detail interacting information
		// in this request.
		pushClient.setChannelLogHandler(new YunLogHandler() {
			@Override
			public void onHandle(YunLogEvent event) {
				System.out.println(event.getMessage());
			}
		});

		try {
			// 4. specify request arguments
			//创建 Android的通知
			JSONObject notification = new JSONObject();
			JSONObject jsonCustormCont = new JSONObject();
			jsonCustormCont.put("type", type);
			jsonCustormCont.put("data", ob); //自定义内容，key-value
			notification.put("wow", jsonCustormCont);

			PushMsgToSingleDeviceRequest request = new PushMsgToSingleDeviceRequest()
					.addChannelId(channelid)//"4262492356657242983"
					.addMsgExpires(new Integer(3600)). // message有效时间
					addMessageType(0).// 1：通知,0:透传消息. 默认为0 注：IOS只有通知.
					addMessage(notification.toString()).
					addDeviceType(3);// deviceType => 3:android, 4:ios
			// 5. http request
			PushMsgToSingleDeviceResponse response = pushClient
					.pushMsgToSingleDevice(request);
			// Http请求结果解析打印
			System.out.println("msgId: " + response.getMsgId() + ",sendTime: "
					+ response.getSendTime());
		} catch (PushClientException e) {
			/*
			 * ERROROPTTYPE 用于设置异常的处理方式 -- 抛出异常和捕获异常,'true' 表示抛出, 'false' 表示捕获。
			 */
			if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				e.printStackTrace();
			}
		} catch (PushServerException e) {
			if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				System.out.println(String.format(
						"requestId: %d, errorCode: %d, errorMessage: %s",
						e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
			}
		}
	}
}
