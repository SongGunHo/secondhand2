package org.koreait.global.libs;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

@Component
@RequiredArgsConstructor
public class Utils {

    private final HttpServletRequest request;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;

    /**
     * CSS, JS 버전
     *
     * @return
     */
    public int version() {
        return 1;
    }

    public String keywords() {
        return "";
    }

    public String description() {
        return "";
    }

    /**
     * 휴대폰 장비 인지, PC 인지
     *
     * @return
     */
    public boolean isMobile() {
        String ua = request.getHeader("User-Agent");

        String pattern = ".*(iPhone|iPod|iPad|BlackBerry|Android|Windows CE|LG|MOT|SAMSUNG|SonyEricsson).*";

        return StringUtils.hasText(ua) && ua.matches(pattern);
    }

    /**
     * mobile, front 템플릿을 분리
     *
     * @param path
     * @return
     */
    public String tpl(String path) {
        String prefix = isMobile() ? "mobile" : "front";

        return String.format("%s/%s", prefix, path);
    }

    /**
     * 메세지를 코드로 조회
     *
     * @param code
     * @return
     */
    public String getMessage(String code) {
        Locale locale = localeResolver.resolveLocale(request);

        return messageSource.getMessage(code, null, locale);
    }
    public  List<String> getMessage(String[] codes){
        return Arrays.stream(codes).map(this :: getMessage).toList();
    }

    /**
     * 커맨드 객체 실패 머세지 처리 (rest)
     * @param errors
     * @return
     */

    public Map<String , List<String>>  getErrorMessage(Errors errors){
        // 필드벌 실페 메시지 - rejectvalu  카멘드 객체 검증 필드
       Map<String,List<String>> message =errors.getFieldErrors().stream().collect(Conllectors.toMap(FieldError::getField , f-> getErrorMessage(f->f.getCodes)));
    }



    public String getParam(String name) {
        return request.getParameter(name);
    }
}

