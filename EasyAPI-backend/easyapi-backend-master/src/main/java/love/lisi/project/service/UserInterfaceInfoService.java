package love.lisi.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import love.lisi.easyapicommon.model.entity.UserInterfaceInfo;

/**
 * 用户接口信息服务
 *
 */
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {


    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    /**
     * 调用接口后次数改变
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);

    /**
     * 查询剩余调用次数
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    int leftInvokeCount(long interfaceInfoId, long userId);
}
