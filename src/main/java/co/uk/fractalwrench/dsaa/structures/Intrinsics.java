package co.uk.fractalwrench.dsaa.structures;

class Intrinsics {
    static void requireNotEmpty(String str) {
        if (str == null || "".equals(str)) {
            throw new IllegalArgumentException();
        }
    }
}
