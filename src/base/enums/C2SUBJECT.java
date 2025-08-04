package base.enums;

public enum C2SUBJECT {
    SUBJECT_1(0b0001),
    SUBJECT_2(0b0010),
    SUBJECT_3(0b0011),
    SUBJECT_4(0b0100),
    SUBJECT_5(0b0101),
    SUBJECT_6(0b0110),
    SUBJECT_7(0b0111),
    SUBJECT_8(0b1000),
    SUBJECT_9(0b1001),
    SUBJECT_10(0b1010),
    SUBJECT_11(0b1011),
    SUBJECT_12(0b1100),
    SUBJECT_13(0b1101),
    SUBJECT_14(0b1110),
    SUBJECT_15(0b1111);

    private final int value;

    C2SUBJECT(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
