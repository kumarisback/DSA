class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> result = new ArrayList<>();

        // Try every possible starting digit
        for (int startDigit = 1; startDigit <= 9; startDigit++) {

            int current = startDigit;
            int nextDigit = startDigit + 1;

            // Keep appending the next digit
            while (nextDigit <= 9) {

                current = current * 10 + nextDigit;

                if (current >= low && current <= high) {
                    result.add(current);
                }

                nextDigit++;
            }
        }
        Collections.sort(result);
        return result;
    }
}
