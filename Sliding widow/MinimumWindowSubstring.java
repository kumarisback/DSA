class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        int need = t.length();
        int have = 0;

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            if (map.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);

                if (window.get(c) <= map.get(c)) {
                    have++;
                }
            }

            while (have == need) {
                if (r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    start = l;
                }

                char remove = s.charAt(l);

                if (map.containsKey(remove)) {
                    window.put(remove, window.get(remove) - 1);

                    if (window.get(remove) < map.get(remove)) {
                        have--;
                    }
                }

                l++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLength);
    }
}
