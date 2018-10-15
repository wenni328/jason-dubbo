package com.jason.dubbo.provider.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.fastjson.JSON;
import com.jason.dubbo.provider.api.utils.BaseException;
import lombok.extern.slf4j.Slf4j;

/**   
* @Description: dubbo rpc 过滤器 统一日志输出
* @author hewenfeng   
* @date 2017年11月28日 下午5:30:53 
* @version V1.0   
*/
@Activate(group = {Constants.CONSUMER})
@Slf4j
public class DubboRpcConsumerFilter implements Filter {

	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) {
		Object[] arguments = invocation.getArguments();
		StringBuilder buff = new StringBuilder();
		for (Object arg : arguments) {
			if (buff.length() >0) {
				buff.append(",");
			}
			buff.append(JSON.toJSONString(arg));
		}
		//String arguments = Arrays.toString(invocation.getArguments());
		long start = System.currentTimeMillis();
		Result result = invoker.invoke(invocation);
		long elapsed = System.currentTimeMillis() - start;
		log.info("[{}], method:{}, arguments:{}, result:{}, elapsed:{}",
				invoker.getInterface(), invocation.getMethodName(),
				buff.toString() , result.getValue(), elapsed);
		if(elapsed>2000) {//超过2秒输出警告
			log.warn("rpc调用耗时超过2秒,[{}], method:{}, arguments:{}, elapsed:{}",
				invoker.getInterface(), invocation.getMethodName(), 
				arguments , elapsed);
		}
		if(result.hasException()) {//系统异常
			Throwable exception = result.getException();
			log.error("rpc异常,[{}], method:{}, arguments:{}.exception:{}",
					invoker.getInterface(), invocation.getMethodName(), 
					arguments ,exception.getMessage());
			throw new BaseException(exception.getMessage(),exception);
		}
		
		return result;
		
	} 
}
