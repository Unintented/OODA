package base.enums;

public enum C2GROUP {
    GROUP_1(0b0001),
    GROUP_2(0b0010),
    GROUP_3(0b0011),
    GROUP_4(0b0100),
    GROUP_5(0b0101),
    GROUP_6(0b0110),
    GROUP_7(0b0111),
    GROUP_8(0b1000),
    GROUP_9(0b1001),
    GROUP_10(0b1010),
    GROUP_11(0b1011),
    GROUP_12(0b1100),
    GROUP_13(0b1101),
    GROUP_14(0b1110),
    GROUP_15(0b1111);

    private final int value;

    C2GROUP(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
