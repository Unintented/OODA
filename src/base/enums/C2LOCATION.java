package base.enums;

public enum C2LOCATION {
    LOC_1(0b0001),
    LOC_2(0b0010),
    LOC_3(0b0011),
    LOC_4(0b0100),
    LOC_5(0b0101),
    LOC_6(0b0110),
    LOC_7(0b0111),
    LOC_8(0b1000),
    LOC_9(0b1001),
    LOC_10(0b1010),
    LOC_11(0b1011),
    LOC_12(0b1100),
    LOC_13(0b1101),
    LOC_14(0b1110),
    LOC_15(0b1111);

    private final int value;

    C2LOCATION(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
