package love.lisi.easyapicommon.service;

/**
 * 内部用户接口信息服务
 *
 */
public interface InnerUserInterfaceInfoService {

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
