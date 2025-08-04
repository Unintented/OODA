package base.enums;

public enum C2LEVEL {
    LEVEL_1(0b0001),
    LEVEL_2(0b0010),
    LEVEL_3(0b0011),
    LEVEL_4(0b0100);

    private final int value;

    C2LEVEL(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
