package base.enums;

public enum C2CABIN {
    CABIN_1(0b0001),
    CABIN_2(0b0010),
    CABIN_3(0b0011),
    CABIN_4(0b0100),
    CABIN_5(0b0101),
    CABIN_6(0b0110),
    CABIN_7(0b0111),
    CABIN_8(0b1000),
    CABIN_9(0b1001),
    CABIN_10(0b1010),
    CABIN_11(0b1011),
    CABIN_12(0b1100),
    CABIN_13(0b1101),
    CABIN_14(0b1110),
    CABIN_15(0b1111);

    private final int value;

    C2CABIN(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
