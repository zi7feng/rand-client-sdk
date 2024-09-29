package com.fzq.randclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;

import static com.fzq.randclientsdk.utils.SignUtils.genSign;

public class RandClient {
    private String accessKey;

    private String secretKey;

    public RandClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }



    public int genRandNumberZeroToTen() {
        try {
            String body = "";
            Map<String, String> headers = getHeaderMap(body);
            HttpResponse response = HttpRequest.get("34.219.214.45/api/rand/number/small")
                    .addHeaders(headers)
                    .execute();

            return Integer.parseInt(response.body());
        } catch (Exception e) {
            throw new RuntimeException("Failed to get random number", e);
        }
    }

    private Map<String, String> getHeaderMap(String body) {
        Map<String, String> hashMap = new HashMap<>();
        String nonce;
        do {
            nonce = RandomUtil.randomNumbers(10);
        } while (isNonceUsed(nonce));
        hashMap.put("accessKey", accessKey);
        hashMap.put("nonce", nonce);
        hashMap.put("body", body);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("sign", genSign(hashMap, secretKey));

        return hashMap;
    }

    private boolean isNonceUsed(String nonce) {
        // Send a request to the /check interface to verify whether the nonce has been used
        String url = "34.219.214.45/api/nonce/check?nonce=" + nonce;
        HttpResponse response = HttpRequest.get(url).execute();
        return Boolean.parseBoolean(response.body());
    }
}
