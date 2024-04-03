package love.lisi.easyapiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import love.lisi.easyapiclientsdk.model.User;
import love.lisi.easyapiclientsdk.utils.SignUtils;


import java.util.HashMap;
import java.util.Map;

/**
 * 调用第三方接口的客户端
 *
 */
public class EasyApiClient {

    private static final String GATEWAY_HOST = "http://localhost:8090";

    private String accessKey;

    private String secretKey;

    public EasyApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getNameByGet(String name) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.get(GATEWAY_HOST + "/api/name/", paramMap);
        System.out.println(result);
        return result;
    }

    public String getNameByPost(String name) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.post(GATEWAY_HOST + "/api/name/", paramMap);
        System.out.println(result);
        return result;
    }

    /**
     * 将ak和加密后的sk封装在请求头中
     * @param body
     * @return
     */
    private Map<String, String> getHeaderMap(String body) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey", accessKey);  //ak
        //随机值，服务端验证新请求的nonce有没有使用过（每次请求将唯一标识保存，待下次请求进来后进行比对判断。可设置保存时长），防止重放
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("body", body);
        //时间戳，服务器会取出请求头中的时间戳与当前时间比对，判断是否该请求已过期，阻止过期请求的重放
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("sign", SignUtils.genSign(body, secretKey));
        return hashMap;
    }

    public String getUsernameByPost(User user) {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + "/api/name/user")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        //System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        //System.out.println(result);
        return result;
    }
}
