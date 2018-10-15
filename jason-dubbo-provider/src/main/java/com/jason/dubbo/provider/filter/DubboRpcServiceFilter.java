package com.jason.dubbo.provider.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;

/**   
* @Description: dubbo rpc 过滤器 统一日志输出
* @author hewenfeng   
* @date 2017年11月28日 下午5:30:53 
* @version V1.0   
*/
@Activate(group = {Constants.PROVIDER})
@Slf4j
public class DubboRpcServiceFilter implements Filter {
	Logger logger = LoggerFactory.getLogger(DubboRpcServiceFilter.class);
	
	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) {
		String arguments = Arrays.toString(invocation.getArguments());
		long start = System.currentTimeMillis();
		Result result = invoker.invoke(invocation);
		long elapsed = System.currentTimeMillis() - start;
		logger.info("[{}], method:{}, arguments:{}, result:{}, elapsed:{}", 
				invoker.getInterface(), invocation.getMethodName(), 
				arguments , result.getValue(), elapsed);
		if(elapsed>2000) {//超过2秒输出警告
			logger.warn("rpc调用耗时超过2秒,[{}], method:{}, arguments:{}, elapsed:{}", 
				invoker.getInterface(), invocation.getMethodName(), 
				arguments , elapsed);
		}
		if(result.hasException()) {
			Throwable exception = result.getException();
			logger.error("marketing rpc异常,[{}], method:{}, arguments:{}.exception:{}", 
					invoker.getInterface(), invocation.getMethodName(), 
					arguments ,exception.getMessage());
			RpcResult rpcResult= (RpcResult) result;
			rpcResult.setException(null);
			rpcResult.setValue(exception.getMessage());
		}
		
		return result;
		
	} 
}
