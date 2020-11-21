package com.study.springbootsecurity.entity;

import java.io.Serializable;

/**
 * (SysPermission)实体类
 *
 * @author makejava
 * @since 2020-11-21 15:59:37
 */
public class SysPermission implements Serializable {
    private static final long serialVersionUID = -83275156577443975L;

    private Integer id;

    private String permname;

    private String permtag;
    /**
     * 请求url
     */
    private String url;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermname() {
        return permname;
    }

    public void setPermname(String permname) {
        this.permname = permname;
    }

    public String getPermtag() {
        return permtag;
    }

    public void setPermtag(String permtag) {
        this.permtag = permtag;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}