class Solution {
    public int bitwiseComplement(int n) {
        int bitLen = Integer.toBinaryString(n).length();
        int bitMask = (1<<bitLen)-1;
        return n^bitMask;
    }
}
