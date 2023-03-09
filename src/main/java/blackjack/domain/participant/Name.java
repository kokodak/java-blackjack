package blackjack.domain.participant;

import java.util.Objects;

public class Name {

    private static final int UPPER_BOUND = 10;
    private static final String RESTRICT = "딜러";

    private final String value;

    public Name(final String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String value) {
        validateNullAndBlank(value);
        validateLength(value);
        validateRestrictWord(value);
    }

    private void validateNullAndBlank(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("이름은 존재해야 합니다. 현재 이름: " + value);
        }
    }

    private void validateLength(final String value) {
        if (value.length() > UPPER_BOUND) {
            throw new IllegalArgumentException("이름은 " + UPPER_BOUND + "글자 이하여야 합니다. 현재 이름: " + value);
        }
    }

    private void validateRestrictWord(final String value) {
        if (value.equals(RESTRICT)) {
            throw new IllegalArgumentException("이름은 " + RESTRICT + "일 수 없습니다. 현재 이름: " + value);
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
