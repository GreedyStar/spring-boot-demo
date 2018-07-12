package cn.greedystar.springbootdemo.common;

import cn.greedystar.springbootdemo.utils.StringUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.UUID;

/**
 * Author GreedyStar
 * Date   2018/7/11
 */
public class BaseEntity implements Serializable {
    private String id;

    public String getId() {
        return id;
    }

    @JsonIgnore
    public boolean isNewRecord() {
        return StringUtils.isBlank(this.id);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void preInsert() {
        setId(UUID.randomUUID().toString().replaceAll("-", ""));
    }

}
