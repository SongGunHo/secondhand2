package org.koreait.board.exception;

import org.koreait.global.exceptions.script.AlertException;
import org.springframework.http.HttpStatus;

public class BoardNotFoundException extends AlertException {
    public BoardNotFoundException(String message) {
        super("NotFoundException", HttpStatus.NOT_FOUND);
        setErrorCode(true);
    }
}
