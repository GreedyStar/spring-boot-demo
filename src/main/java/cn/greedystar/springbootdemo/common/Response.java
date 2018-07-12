package cn.greedystar.springbootdemo.common;

import java.io.Serializable;

/**
 * Author GreedyStar
 * Date   2018/7/12
 */
public class Response implements Serializable {
    private Object data;
    private Meta meta;

    public Response() {

    }

    public Response(Builder builder) {
        if (this.meta == null) {
            meta = new Meta();
        }
        this.data = builder.data;
        this.meta.message = builder.message;
        this.meta.status = builder.status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    private class Meta {
        private int status;
        private String message;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }


    public static class Builder {
        private Object data;
        private int status;
        private String message;

        public Builder() {
        }

        public Builder setData(Object data) {
            this.data = data;
            return this;
        }

        public Builder setStatus(int status) {
            this.status = status;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Response build() {
            return new Response(this);
        }
    }

}
