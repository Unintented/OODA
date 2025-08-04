package base.enums;

public enum C2OPPS {
    OPPS_1(0b0001),
    OPPS_2(0b0010),
    OPPS_3(0b0011),
    OPPS_4(0b0100),
    OPPS_5(0b0101),
    OPPS_6(0b0110),
    OPPS_7(0b0111),
    OPPS_8(0b1000),
    OPPS_9(0b1001),
    OPPS_10(0b1010),
    OPPS_11(0b1011),
    OPPS_12(0b1100),
    OPPS_13(0b1101),
    OPPS_14(0b1110),
    OPPS_15(0b1111);

    private final int value;

    C2OPPS(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
