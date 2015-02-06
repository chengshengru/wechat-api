package com.qq.weixin.api.model;

import net.sf.json.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 程胜儒 on 2015/2/5.
 * 微信用户信息
 */
public class WechatUserInfo implements Serializable{



    /**
     * 昵称
     */
    private String mNickName;

    /**
     * 微信OpenId
     */
    private String mOpenId;

    /**
     *  微信用户是关注时间
     */
    private Date mSubTime;


    /**
     * 是否订阅
     */
    private Integer isSubscribe=0;

    /**
     * 省份
     */
    private String mProvince;
    /**
     * 城市
     */
    private String mCity;
    /**
     * 所在的市区
     */
    private String mDistrict;

    /**
     * 国家
     */
    private String  mCountry;


    /**
     * 微信UnionId（同一个微信帐号，UnionId唯一）
     */
    private String mUnionId;
    /**
     * 性别
     * 0 未知
     * 1 男
     * 2 女
     */
    private Integer mGender;
    /**
     * 头像地址
     */
    private String mAvatar;


    public WechatUserInfo(JSONObject param) {
        if (param!=null){
            isSubscribe=param.optInt("subscribe", 0);
            mOpenId=param.optString("openid",null);
            mCity=param.optString("city", null);
            mProvince=param.optString("province", null);
            mAvatar=param.optString("headimgurl", null);
            mNickName=param.optString("nickname", null);
            mCountry=param.optString("country", null);
            long time=param.optLong("subscribe_time",System.currentTimeMillis()/1000)*1000;
            mSubTime=new Date(time);
            mGender=param.optInt("sex", 0);
        }
    }

    public WechatUserInfo() {

    }


    public String getNickName() {
        return mNickName;
    }

    public void setNickName(String mNickName) {
        this.mNickName = mNickName;
    }

    public String getOpenId() {
        return mOpenId;
    }

    public void setOpenId(String mOpenId) {
        this.mOpenId = mOpenId;
    }

    public Date getSubTime() {
        return mSubTime;
    }

    public void setSubTime(Date mSubTime) {
        this.mSubTime = mSubTime;
    }

    public Integer getIsSubscribe() {
        return isSubscribe;
    }

    public void setIsSubscribe(Integer isSubscribe) {
        this.isSubscribe = isSubscribe;
    }

    public String getProvince() {
        return mProvince;
    }

    public void setProvince(String mProvince) {
        this.mProvince = mProvince;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String mCity) {
        this.mCity = mCity;
    }

    public String getDistrict() {
        return mDistrict;
    }

    public void setDistrict(String mDistrict) {
        this.mDistrict = mDistrict;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String mCountry) {
        this.mCountry = mCountry;
    }

    public String getUnionId() {
        return mUnionId;
    }

    public void setUnionId(String mUnionId) {
        this.mUnionId = mUnionId;
    }

    public Integer getGender() {
        return mGender;
    }

    public void setGender(Integer mGender) {
        this.mGender = mGender;
    }

    public String getAvatar() {
        return mAvatar;
    }

    public void setAvatar(String mAvatar) {
        this.mAvatar = mAvatar;
    }
}
