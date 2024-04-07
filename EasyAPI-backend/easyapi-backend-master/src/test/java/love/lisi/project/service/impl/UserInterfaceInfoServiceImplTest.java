package love.lisi.project.service.impl;

import lombok.extern.slf4j.Slf4j;
import love.lisi.easyapicommon.service.InnerUserInterfaceInfoService;
import love.lisi.project.service.UserInterfaceInfoService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
class UserInterfaceInfoServiceImplTest {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;
    @Test
    void leftInvokeCountTest() {
        int leftCount = userInterfaceInfoService.leftInvokeCount(21, 3);
        log.info("leftCount==>{}",leftCount);
    }
}