package com.mky.springbootmky;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 요청 값에 따라 서로 다른 HTTP 상태 코드를 반환하는 퀴즈용 컨트롤러.
 *
 * <p>{@link ResponseEntity}를 사용해 응답 본문과 상태 코드를 함께 지정하는 방법을 연습한다.
 */
@RestController
public class QuizController {

    /**
     * 쿼리 파라미터 {@code code} 값에 따라 응답 상태 코드를 결정한다.
     *
     * <ul>
     *   <li>{@code code=1} → 201 Created, 본문 "Created!"</li>
     *   <li>{@code code=2} → 400 Bad Request, 본문 "Bad Request!"</li>
     *   <li>그 외 → 200 OK, 본문 "OK!"</li>
     * </ul>
     *
     * @param code 쿼리 파라미터로 전달되는 정수 코드 (예: {@code GET /quiz?code=1})
     * @return 상태 코드와 메시지를 담은 응답
     */
    @GetMapping("/quiz")
    public ResponseEntity<String> quiz(@RequestParam("code") int code) {
        switch (code) {
            case 1:
                return ResponseEntity.created(null).body("Created!");
            case 2:
                return ResponseEntity.badRequest().body("Bad Request!");
            default:
                return ResponseEntity.ok().body("OK!");
        }
    }

    /**
     * 요청 본문(JSON)의 {@code value} 값에 따라 응답 상태 코드를 결정한다.
     *
     * <ul>
     *   <li>{@code value=1} → 403 Forbidden, 본문 "Forbidden!"</li>
     *   <li>그 외 → 200 OK, 본문 "OK!"</li>
     * </ul>
     *
     * @param code 요청 본문에서 역직렬화된 코드 객체 (예: {@code {"value": 1}})
     * @return 상태 코드와 메시지를 담은 응답
     */
    @PostMapping("/quiz")
    public ResponseEntity<String> quiz2(@RequestBody Code code) {

        switch (code.value()) {
            case 1:
                return ResponseEntity.status(403).body("Forbidden!");
            default:
                return ResponseEntity.ok().body("OK!");
        }
    }
}

/**
 * {@code POST /quiz} 요청 본문을 매핑하는 레코드.
 *
 * @param value 응답 상태 코드를 결정하는 정수 값
 */
record Code(int value) {}
