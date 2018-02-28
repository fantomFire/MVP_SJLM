package com.zhss.sjlm.exception;



public class TokenErrorException extends BaseException {
    public TokenErrorException(String code, String displayMessage) {
        super(code, displayMessage);
    }
}
