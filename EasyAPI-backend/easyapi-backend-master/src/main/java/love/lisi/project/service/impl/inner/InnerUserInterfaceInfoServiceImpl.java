package love.lisi.project.service.impl.inner;

import love.lisi.easyapicommon.service.InnerUserInterfaceInfoService;
import love.lisi.project.service.UserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * 内部用户接口信息服务实现类
 *
 */
@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
    }

    @Override
    public int leftInvokeCount(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.leftInvokeCount(interfaceInfoId,userId);
    }
}
