package com.kotlin.usercenter.data.response;

/**
 * author : dufeihu
 * date   : 2019/8/29 16:06
 * desc   :
 */
public class UserInfo {

    /**
     * userId : 593466796858671104
     * userName : 哈喽
     * mobile : 18165041160
     * idNo : 510824197101104412
     * idKind : null
     * bankCardNo : null
     * bankName : null
     * tokenId : C_593466796858671104_587d8c6cb6
     */

    private String userId;
    private String userName;
    private String mobile;
    private String idNo;
    private Object idKind;
    private Object bankCardNo;
    private Object bankName;
    private String tokenId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public Object getIdKind() {
        return idKind;
    }

    public void setIdKind(Object idKind) {
        this.idKind = idKind;
    }

    public Object getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(Object bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public Object getBankName() {
        return bankName;
    }

    public void setBankName(Object bankName) {
        this.bankName = bankName;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }
}
