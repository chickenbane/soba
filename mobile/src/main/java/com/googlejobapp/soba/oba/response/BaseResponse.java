package com.googlejobapp.soba.oba.response;

/**
 * The OBA wraps all of its responses in this class.
 *
 * First rule of creating OBA response beans: trust actual server responses, the documentation alone will mislead you.
 *
 * Similarly, since using Retrofit, trust Retrofit responses over browser calls HTTP calls, they can be different responses. Awesome.
 *
 * Created by joeyt on 10/15/14.
 */
public abstract class BaseResponse {
    private long currentTime;
    private int code;
    private int version;
    private String text;

    public long getCurrentTime() {
        return currentTime;
    }

    public int getCode() {
        return code;
    }

    public int getVersion() {
        return version;
    }

    public String getText() {
        return text;
    }

    public String getBaseResponseString() {
        return "code=" + code + " text=" + text + " version=" + version + " currentTime=" + currentTime;
    }

    public abstract References getReferences();
}
