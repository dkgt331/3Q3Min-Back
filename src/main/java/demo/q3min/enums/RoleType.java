package demo.q3min.enums;

import java.util.Arrays;

public enum RoleType {
    USER("ROLE_USER", "일반 사용자 권한"),
    ADMIN("ROLE_ADMIN", "관리자 권한"),
    GUEST("GUEST", "게스트 권한");

    RoleType(String code, String displayName) {
        this.code = code;
        this.displayName = displayName;
    }

    private final String code;
    private final String displayName;

    public String getCode() {
        return this.code;
    }

    public static RoleType of(String code) {
        return Arrays.stream(RoleType.values())
                .filter(r -> r.getCode().equals(code))
                .findAny()
                .orElse(GUEST);
    }
}
